import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FuncionarioService} from '../../services/funcionario-service/funcionario-service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {FuncionarioCompleto} from '../../model/FuncionarioCompleto';
import {BasicInput} from '../../inputs/basic-input/basic-input';
import {CargoSelector} from '../../inputs/cargo-selector/cargo-selector';
import {Division} from '../../layouts/division/division';
import {EstadoSelector} from '../../inputs/estado-selector/estado-selector';
import {ToogleInput} from '../../inputs/toogle-input/toogle-input';
import {ListSelector} from '../../inputs/list-selector/list-selector';
import {InputLabel} from '../../directives/input-label';
import {InputId} from '../../directives/input-id';
import {InputName} from '../../directives/input-name';
import {SelectName} from '../../directives/select-name';
import {BasicSelector} from '../../inputs/basic-selector/basic-selector';
import {SelectorOption} from '../../model/SelectorOption';
import {CargoService} from '../../services/cargo-service/cargo-service';
import {switchMap} from 'rxjs';

@Component({
  selector: 'app-alterar-funcionario-component',
  imports: [
    BasicInput,
    Division,
    EstadoSelector,
    ToogleInput,
    ListSelector,
    InputLabel,
    InputId,
    InputName,
    SelectName,
    BasicSelector,
  ],
  templateUrl: './alterar-funcionario-component.html',
  styleUrl: './alterar-funcionario-component.css'
})
export class AlterarFuncionarioComponent implements OnInit {
  constructor(private funcionarioService: FuncionarioService,
              private cargoService: CargoService,
              private route: ActivatedRoute,
              private cdr : ChangeDetectorRef,
              private location: Location) {
  }

  funcionario : FuncionarioCompleto|null = null;
  cargos : SelectorOption[] = []

  ngOnInit(): void {
    let funcionarioCpf = this.route.snapshot.paramMap.get('cpf')
    if (funcionarioCpf == null) {
      funcionarioCpf = ""
    }
    this.obterFuncionario(funcionarioCpf);
    this.obterCargos();
  }
  obterFuncionario(funcionarioCpf:string){
    this.funcionarioService.obterFuncionarioPorCpf(funcionarioCpf).pipe(
      switchMap(result => {
        this.funcionario = result.data
        return this.cargoService.obterCargos()
      })
    ).subscribe({
      next: result => {
        this.cargos = result.data.map(cargo => new SelectorOption(cargo.id.toString(), cargo.nome))
        this.cdr.detectChanges();
      }
    })
    /*
    this.funcionarioService.obterFuncionarioPorCpf(funcionarioCpf).subscribe({
      next: result => {
        this.funcionario = result.data
        console.log(this.funcionario);
        this.cdr.detectChanges()
      },
      error: error => {
        console.error(error);
      }
    })

     */
  }

  obterCargos(){
    this.cargoService.obterCargos().subscribe({
      next: result => {
        this.cargos = result.data.map(cargo => new SelectorOption(cargo.id.toString(), cargo.nome))
        this.cdr.detectChanges();
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
