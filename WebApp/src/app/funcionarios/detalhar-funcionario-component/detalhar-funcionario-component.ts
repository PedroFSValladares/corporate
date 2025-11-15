import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {BasicInput} from '../../inputs/basic-input/basic-input';
import {BasicSelector} from '../../inputs/basic-selector/basic-selector';
import {FuncionarioService} from '../../services/funcionario-service/funcionario-service';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {FuncionarioCompleto} from '../../model/FuncionarioCompleto';
import {Location} from '@angular/common';
import {CargoSelector} from '../../inputs/cargo-selector/cargo-selector';
import {CargoService} from '../../services/cargo-service/cargo-service';
import {SelectorOption} from '../../model/SelectorOption';
import {switchMap} from 'rxjs';
import {Division} from '../../division/division';

@Component({
  selector: 'app-detalhar-funcionario-component',
  imports: [
    BasicInput,
    BasicSelector,
    CargoSelector,
    Division
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

  funcionario : FuncionarioCompleto|null = null;

  ngOnInit(): void {
    let funcionarioCpf = this.route.snapshot.paramMap.get('cpf')
    if (funcionarioCpf == null) {
      funcionarioCpf = ""
    }
    this.obterFuncionario(funcionarioCpf);
  }
  obterFuncionario(funcionarioCpf:string){
    this.funcionarioService.obterFuncionarioPorCpf(funcionarioCpf).subscribe({
      next: result => {
        this.funcionario = result.data
        this.cdr.detectChanges()
      },
      error: error => {
        console.error(error);
      }
    })
  }

  voltarPagina(){
    this.location.back();
  }
}
