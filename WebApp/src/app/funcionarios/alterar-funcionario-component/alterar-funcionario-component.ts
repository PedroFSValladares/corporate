import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FuncionarioService} from '../../services/funcionario-service/funcionario-service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {FuncionarioCompleto} from '../../model/FuncionarioCompleto';
import {BasicInput} from '../../inputs/basic-input/basic-input';
import {BasicSelector} from '../../inputs/basic-selector/basic-selector';
import {CargoSelector} from '../../inputs/cargo-selector/cargo-selector';
import {Division} from '../../layouts/division/division';
import {EstadoSelector} from '../../inputs/estado-selector/estado-selector';
import {ToogleInput} from '../../inputs/toogle-input/toogle-input';

@Component({
  selector: 'app-alterar-funcionario-component',
  imports: [
    BasicInput,
    BasicSelector,
    CargoSelector,
    Division,
    EstadoSelector,
    ToogleInput
  ],
  templateUrl: './alterar-funcionario-component.html',
  styleUrl: './alterar-funcionario-component.css'
})
export class AlterarFuncionarioComponent implements OnInit {
  constructor(private funcionarioService: FuncionarioService,
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
