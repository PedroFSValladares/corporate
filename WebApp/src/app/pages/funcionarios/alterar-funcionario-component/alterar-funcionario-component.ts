import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FuncionarioService} from '../../../services/funcionario-service/funcionario-service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {FuncionarioCompleto} from '../../../model/FuncionarioCompleto';
import {BasicInput} from '../../../inputs/basic-input/basic-input';
import {Division} from '../../../layouts/division/division';
import {ToogleInput} from '../../../inputs/toogle-input/toogle-input';
import {ListSelector} from '../../../inputs/list-selector/list-selector';
import {InputLabel} from '../../../directives/input-label';
import {InputId} from '../../../directives/input-id';
import {InputName} from '../../../directives/input-name';
import {SelectName} from '../../../directives/select-name';
import {BasicSelector} from '../../../inputs/basic-selector/basic-selector';
import {SelectorOption} from '../../../model/SelectorOption';
import {CargoService} from '../../../services/cargo-service/cargo-service';
import {FuncionariosPage} from '../FuncionariosPage';
import {TransporteService} from '../../../services/transporte-service/transporte-service';

@Component({
  selector: 'app-alterar-funcionario-component',
  imports: [
    BasicInput,
    Division,
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
export class AlterarFuncionarioComponent extends FuncionariosPage implements OnInit {
  constructor(private _funcionarioService: FuncionarioService,
              private _transporteService: TransporteService,
              private _cargoService: CargoService,
              private route: ActivatedRoute,
              private _cdr : ChangeDetectorRef,
              private location: Location) {
    super(_funcionarioService, _transporteService, _cargoService, _cdr);
  }

  ngOnInit(): void {
    let funcionarioCpf = this.route.snapshot.paramMap.get('cpf')
    if (funcionarioCpf == null) {
      funcionarioCpf = ""
    }
    this.obterFuncionario(funcionarioCpf);
    this.obterCargos();
    this.setEstados();
    this.obterTransportes();
  }

  voltarPagina(){
    this.location.back();
  }
}
