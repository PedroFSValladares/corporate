import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {BasicInput} from '../../../inputs/basic-input/basic-input';
import {FuncionarioService} from '../../../services/funcionario-service/funcionario-service';
import {ActivatedRoute} from '@angular/router';
import {FuncionarioCompleto} from '../../../model/FuncionarioCompleto';
import {Location} from '@angular/common';
import {Division} from '../../../layouts/division/division';
import {ToogleInput} from '../../../inputs/toogle-input/toogle-input';
import {ListSelector} from '../../../inputs/list-selector/list-selector';
import {InputName} from '../../../directives/input-name';
import {InputLabel} from '../../../directives/input-label';
import {InputId} from '../../../directives/input-id';
import {SelectName} from '../../../directives/select-name';
import {BasicSelector} from '../../../inputs/basic-selector/basic-selector';
import {FuncionariosPage} from '../FuncionariosPage';
import {CargoService} from '../../../services/cargo-service/cargo-service';
import {TransporteService} from '../../../services/transporte-service/transporte-service';

@Component({
  selector: 'app-detalhar-funcionario-component',
  imports: [
    BasicInput,
    Division,
    ToogleInput,
    ListSelector,
    InputName,
    InputLabel,
    InputId,
    SelectName,
    BasicSelector
  ],
  templateUrl: './detalhar-funcionario-component.html',
  styleUrl: './detalhar-funcionario-component.css'
})
export class DetalharFuncionarioComponent extends FuncionariosPage implements OnInit {

  constructor(
    private _funcionarioService: FuncionarioService,
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
  }

  voltarPagina(){
    this.location.back();
  }
}
