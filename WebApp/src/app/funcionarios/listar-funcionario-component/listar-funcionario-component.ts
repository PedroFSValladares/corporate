import {
  ChangeDetectorRef,
  Component,
  ElementRef,
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
import {CargoSelector} from '../../inputs/cargo-selector/cargo-selector';

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
    CargoSelector,
  ],
  templateUrl: './listar-funcionario-component.html',
  styleUrl: './listar-funcionario-component.css'
})
export class ListarFuncionarioComponent{
  constructor(
    private funcionarioService: FuncionarioService,
    private cdr: ChangeDetectorRef) {
  }

  @ViewChildren(BasicInput, {read:  ElementRef})
  formInputs: QueryList<ElementRef> = new QueryList<ElementRef>();
  @ViewChildren(BasicSelector, {read:  ElementRef})
  formSelectors: QueryList<ElementRef> = new QueryList<ElementRef>();
  @ViewChild(CargoSelector, {read:  ElementRef})
  cargoSelector: ElementRef|undefined;


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
    this.funcionarioService.obterTodosOsFuncionarios().subscribe(response => {
      this.funcionarios = response.data
      this.paginar(1);
      this.paginationEnabled = true;
      this.montarListaDePaginas()
      this.cdr.detectChanges();
    })
  }

  limparPesquisa(event: PointerEvent): void {
    event.preventDefault();
    this.funcionarios = [];
    this.paginaAtual = [];
    this.qntdPaginas = [];
    this.formInputs.forEach(input => {input.nativeElement.querySelector('input').value = ''});
    this.formSelectors.forEach(input => {input.nativeElement.querySelector('select').value = ''});
    if(this.cargoSelector)
      this.cargoSelector.nativeElement.querySelector('select').value = ''
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
}
