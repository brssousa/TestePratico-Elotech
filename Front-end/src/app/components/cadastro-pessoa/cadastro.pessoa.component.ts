import {Component, OnInit, ViewChild} from "@angular/core";
import {PessoaService} from "../../service/pessoa.service";
import {ContatoService} from "../../service/contato.service";
import {Contato} from "../../model/contato";
import {Pessoa} from "../../model/pessoa";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'cadastro-pessoa',
  templateUrl: './cadastro.pessoa.component.html',
  styleUrls: ['./cadastro.pessoa.component.css']
})
export class CadastroPessoaComponent implements OnInit{

  @ViewChild('mainForm') mainForm: FormGroup;

  pessoa: Pessoa = new Pessoa();
  contatoList: Contato[]=[];
  contato: Contato = new Contato();

  constructor(public mainService: PessoaService,
              public contatoService: ContatoService) {
  }
  ngOnInit(): void {
    this.contatoService.listAll().subscribe( dados => this.contatoList = dados);
  }

  salvar(){
    this.pessoa.contatoList.push(this.contato);
    this.mainService.save(this.pessoa).subscribe( dados => this.mainForm.reset())
  }

}
