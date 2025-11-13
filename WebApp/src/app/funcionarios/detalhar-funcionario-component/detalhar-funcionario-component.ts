import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {BasicInput} from '../../inputs/basic-input/basic-input';
import {BasicSelector} from '../../inputs/basic-selector/basic-selector';
import {NgbDropdown, NgbDropdownToggle} from '@ng-bootstrap/ng-bootstrap';
import {FuncionarioService} from '../../services/funcionario-service/funcionario-service';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {FuncionarioCompleto} from '../../model/FuncionarioCompleto';
import {Location} from '@angular/common';
import {CargoSelector} from '../../inputs/cargo-selector/cargo-selector';

@Component({
  selector: 'app-detalhar-funcionario-component',
  imports: [
    BasicInput,
    BasicSelector,
    NgbDropdown,
    NgbDropdownToggle,
    RouterLink,
    CargoSelector
  ],
  templateUrl: './detalhar-funcionario-component.html',
  styleUrl: './detalhar-funcionario-component.css'
})
export class DetalharFuncionarioComponent implements OnInit {

  constructor(
    private funcionarioService: FuncionarioService,
    private route: ActivatedRoute,
    private cdr : ChangeDetectorRef,
    private location: Location) {
  }

  funcionario : FuncionarioCompleto = new FuncionarioCompleto();

  ngOnInit(): void {
    let funcionarioCpf = this.route.snapshot.paramMap.get('cpf')
    if (funcionarioCpf == null) {
      funcionarioCpf = ""
    }
    this.funcionarioService.obterFuncionarioPorCpf(funcionarioCpf).subscribe({
      next: result => {
        this.funcionario = result.data;
        this.cdr.detectChanges();
      },
      error: err => {
        console.log(err);
      }
    });
  }

  voltarPagina(){
    this.location.back();
  }
}
