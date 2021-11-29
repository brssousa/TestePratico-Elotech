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
  contatos: Contato[];
  error: boolean = false;
  contato: Contato = new Contato();

  constructor(public mainService: PessoaService,
              public contatoService: ContatoService) {
  }
  ngOnInit(): void {
    this.contatoService.listAll().subscribe( dados => this.contatos = dados);
  }

  salvar(){
    this.mainService.save(this.pessoa).subscribe( dados => {
      this.pessoa = new Pessoa();
      this.mainForm.reset()
      this.error = false;
    },
      error => this.error = true)
  }

  addContato(){
    let contato: Contato;
    this.contatos.forEach( item => {
      if(item.id == this.contato.id){
        contato = item;
      }
    })
    this.pessoa.contatoList.push(contato);
  }

}
