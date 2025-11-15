import {ChangeDetectorRef, Component} from '@angular/core';
import {FuncionarioService} from '../../services/funcionario-service/funcionario-service';
import {CargoService} from '../../services/cargo-service/cargo-service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {FuncionarioCompleto} from '../../model/FuncionarioCompleto';
import {SelectorOption} from '../../model/SelectorOption';
import {switchMap} from 'rxjs';
import {BasicInput} from '../../inputs/basic-input/basic-input';
import {BasicSelector} from '../../inputs/basic-selector/basic-selector';
import {CargoSelector} from '../../inputs/cargo-selector/cargo-selector';
import {Division} from '../../division/division';

@Component({
  selector: 'app-alterar-funcionario-component',
  imports: [
    BasicInput,
    BasicSelector,
    CargoSelector,
    Division
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
