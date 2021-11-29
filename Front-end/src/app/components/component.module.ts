import {NgModule} from "@angular/core";
import {CadastroPessoaComponent} from "./cadastro-pessoa/cadastro.pessoa.component";
import {ListaPessoasComponent} from "./lista-pessoas/lista.pessoas.component";
import {CommonModule} from "@angular/common";
import {PessoaService} from "../service/pessoa.service";
import {FormsModule} from "@angular/forms";
import {CadastroContatoComponent} from "./cadastro-contato/cadastro.contato.component";

@NgModule({
  declarations: [
    CadastroPessoaComponent,
    CadastroContatoComponent,
    ListaPessoasComponent,
  ],
  exports: [
    CadastroPessoaComponent,
    CadastroContatoComponent,
    ListaPessoasComponent,
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  providers: [
    PessoaService
  ]
})
export class ComponentModule{

}
