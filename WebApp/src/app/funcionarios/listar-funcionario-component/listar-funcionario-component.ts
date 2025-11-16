import {
  ChangeDetectorRef,
  Component,
  ElementRef, input, OnInit,
  QueryList,
  ViewChild,
  ViewChildren
} from '@angular/core';
import {FuncionarioResumido} from '../../model/FuncionarioResumido';
import {FuncionarioService} from '../../services/funcionario-service/funcionario-service';
import {RouterLink} from '@angular/router';
import {BasicInput} from '../../inputs/basic-input/basic-input';
import {BasicSelector} from '../../inputs/basic-selector/basic-selector';
import {SelectorOption} from '../../model/SelectorOption';
import {NgbDropdown, NgbDropdownItem, NgbDropdownMenu, NgbDropdownToggle} from '@ng-bootstrap/ng-bootstrap';
import {TableActions} from '../../layouts/table-actions/table-actions';
import {InputLabel} from '../../directives/input-label';
import {FuncionariosPage} from '../FuncionariosPage';
import {CargoService} from '../../services/cargo-service/cargo-service';

@Component({
  selector: 'app-listar-funcionario-component',
  imports: [
    RouterLink,
    BasicInput,
    BasicSelector,
    NgbDropdown,
    NgbDropdownToggle,
    NgbDropdownMenu,
    NgbDropdownItem,
    TableActions,
    InputLabel
  ],
  templateUrl: './listar-funcionario-component.html',
  styleUrl: './listar-funcionario-component.css'
})
export class ListarFuncionarioComponent extends FuncionariosPage implements OnInit{
  constructor(
    private _funcionarioService: FuncionarioService,
    private _cargoService: CargoService,
    private _cdr: ChangeDetectorRef) {
    super(_funcionarioService, _cargoService, _cdr);
  }

  @ViewChildren(BasicInput, {read:  ElementRef})
  formInputs: QueryList<ElementRef> = new QueryList<ElementRef>();
  @ViewChildren(BasicSelector, {read:  ElementRef})
  formSelectors: QueryList<ElementRef> = new QueryList<ElementRef>();


  funcionarios : FuncionarioResumido[] = [];
  status: SelectorOption[] = [
    new SelectorOption("true", "Ativo"),
    new SelectorOption("false", "Inativo")
  ];
  paginaAtual: FuncionarioResumido[] = [];
  numeroPaginaAtual: number = 1;
  qntdResgistrosAMostrar: number = 10;
  pageOffset: number = 1;
  qntdPaginas: number[] = [];
  paginationEnabled: boolean = false;

  buscarFuncionarios(event: PointerEvent): void {
    event.preventDefault();
    this._funcionarioService.obterTodosOsFuncionarios().subscribe(response => {
      this.funcionarios = response.data
      this.paginar(1);
      this.paginationEnabled = true;
      this.montarListaDePaginas()
      this._cdr.detectChanges();
    })
  }

  limparPesquisa(event: PointerEvent): void {
    event.preventDefault();
    this.funcionarios = [];
    this.paginaAtual = [];
    this.qntdPaginas = [];
    this.formInputs.forEach(input => {input.nativeElement.querySelector('input').value = ''});
    this.formSelectors.forEach(input => {input.nativeElement.querySelector('select').value = ''});
    this.paginationEnabled = false;
    this.pageOffset = 1;
    this.numeroPaginaAtual = 1;
    this.qntdResgistrosAMostrar = 10;
  }

  paginar(pagina : number): void {
    this.pageOffset = (pagina * this.qntdResgistrosAMostrar) - this.qntdResgistrosAMostrar;
    this.numeroPaginaAtual = pagina;
    this.paginaAtual = this.funcionarios.slice(this.pageOffset, pagina * this.qntdResgistrosAMostrar);
  }

  alterarQntdRegistros(numero: number): void {
    this.qntdResgistrosAMostrar = numero;
    this.paginar(this.numeroPaginaAtual);
    this.montarListaDePaginas();
  }

  montarListaDePaginas() : void {
    this.qntdPaginas = []
    for(let i = 1; i <= this.funcionarios.length / this.qntdResgistrosAMostrar; i++) {
      this.qntdPaginas.push(i);
    }
    if(this.funcionarios.length % 10 > 0){
      this.qntdPaginas.push(Math.trunc(this.funcionarios.length / this.qntdResgistrosAMostrar) + 1);
    }
  }

  ngOnInit(): void {
    this.obterCargos();
  }
}
