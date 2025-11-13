import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {BasicInput} from '../../inputs/basic-input/basic-input';
import {BasicSelector} from '../../inputs/basic-selector/basic-selector';
import {NgbDropdown, NgbDropdownToggle} from '@ng-bootstrap/ng-bootstrap';
import {FuncionarioService} from '../../services/funcionario-service/funcionario-service';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {FuncionarioCompleto} from '../../model/FuncionarioCompleto';
import {Location} from '@angular/common';
import {CargoSelector} from '../../inputs/cargo-selector/cargo-selector';
import {CargoService} from '../../services/cargo-service/cargo-service';
import {SelectorOption} from '../../model/SelectorOption';
import {switchMap} from 'rxjs';

@Component({
  selector: 'app-detalhar-funcionario-component',
  imports: [
    BasicInput,
    BasicSelector,
    NgbDropdown,
    NgbDropdownToggle
  ],
  templateUrl: './detalhar-funcionario-component.html',
  styleUrl: './detalhar-funcionario-component.css'
})
export class DetalharFuncionarioComponent implements OnInit {

  constructor(
    private funcionarioService: FuncionarioService,
    private cargoService: CargoService,
    private route: ActivatedRoute,
    private cdr : ChangeDetectorRef,
    private location: Location) {
  }

  funcionario : FuncionarioCompleto = new FuncionarioCompleto();
  cargoOption : SelectorOption[] = []
  UF : SelectorOption[] = []

  ngOnInit(): void {
    let funcionarioCpf = this.route.snapshot.paramMap.get('cpf')
    if (funcionarioCpf == null) {
      funcionarioCpf = ""
    }
    this.obterFuncionario(funcionarioCpf);
  }
  obterFuncionario(funcionarioCpf:string){
    let teste = this.funcionarioService.obterFuncionarioPorCpf(funcionarioCpf)
      .pipe(switchMap(result => {
        this.funcionario = result.data;
        this.UF.push(new SelectorOption("0", result.data.endereco.uf))
      return this.cargoService.obterCargoPorId(result.data.cargoId);
    })).subscribe({
      next: (result)=>{
        this.cargoOption.push(new SelectorOption(result.data.id.toString(), result.data.nome))
        this.cdr.detectChanges();
      },
      error: (error)=>{
        console.error(error);
      }
    });
  }

  obterCargoFuncionario(cargoId:number){
    this.cargoService.obterCargoPorId(cargoId).subscribe({
      next: result => {
        this.cargoOption.push(new SelectorOption(result.data.id.toString(), result.data.nome));
      }
    })
  }

  voltarPagina(){
    this.location.back();
  }
}
