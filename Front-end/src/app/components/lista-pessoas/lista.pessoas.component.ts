import {Component, OnInit} from "@angular/core";
import {Pessoa} from "../../model/pessoa";
import {PessoaService} from "../../service/pessoa.service";

@Component({
  selector: 'lista-pessoas',
  templateUrl: './lista.pessoas.component.html',
  styleUrls: ['./lista.pessoas.component.css']
})
export class ListaPessoasComponent implements OnInit{

  pessoas: Pessoa[]=[];

  constructor(public service: PessoaService) {
  }

  ngOnInit(): void {
    this.service.list().subscribe( dados => this.pessoas = dados);
  }

}
