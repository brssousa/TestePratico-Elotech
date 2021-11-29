import {Component, OnInit, ViewChild} from "@angular/core";
import {Contato} from "../../model/contato";
import {ContatoService} from "../../service/contato.service";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'cadastro-contato',
  templateUrl: './cadastro.contato.component.html',
  styleUrls: ['./cadastro.contato.component.css']
})
export class CadastroContatoComponent{

  contato: Contato = new Contato();
  error: boolean = false;
  @ViewChild('mainForm') mainForm: FormGroup;

  constructor(public mainService: ContatoService) {
  }

  salvar(){
    this.mainService.save(this.contato).subscribe( dados => {
      this.mainForm.reset()
      this.error = false;
    },
      error => this.error = true);
  }

}
