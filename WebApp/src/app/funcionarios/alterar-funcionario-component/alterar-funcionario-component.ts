import {ChangeDetectorRef, Component} from '@angular/core';
import {FuncionarioLayout} from '../../form-layouts/funcionario-layout/funcionario-layout';
import {FuncionarioService} from '../../services/funcionario-service/funcionario-service';
import {CargoService} from '../../services/cargo-service/cargo-service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {FuncionarioCompleto} from '../../model/FuncionarioCompleto';
import {SelectorOption} from '../../model/SelectorOption';
import {switchMap} from 'rxjs';

@Component({
  selector: 'app-alterar-funcionario-component',
  imports: [
    FuncionarioLayout
  ],
  templateUrl: './alterar-funcionario-component.html',
  styleUrl: './alterar-funcionario-component.css'
})
export class AlterarFuncionarioComponent {
  constructor(private funcionarioService: FuncionarioService,
              private cargoService: CargoService,
              private route: ActivatedRoute,
              private cdr : ChangeDetectorRef,
              private location: Location) {
  }

  funcionario : FuncionarioCompleto|null = null;
  cargoOption : SelectorOption[] = []

  ngOnInit(): void {
    let funcionarioCpf = this.route.snapshot.paramMap.get('cpf')
    if (funcionarioCpf == null) {
      funcionarioCpf = ""
    }
    this.obterFuncionario(funcionarioCpf);
  }
  obterFuncionario(funcionarioCpf:string){
    this.funcionarioService.obterFuncionarioPorCpf(funcionarioCpf)
      .pipe(switchMap(result => {
        this.funcionario = result.data;
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

  voltarPagina(){
    this.location.back();
  }
}
