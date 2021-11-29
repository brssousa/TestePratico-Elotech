import {NgModule} from "@angular/core";
import {CadastroPessoaComponent} from "./cadastro-pessoa/cadastro.pessoa.component";
import {ListaPessoasComponent} from "./lista-pessoas/lista.pessoas.component";
import {CommonModule} from "@angular/common";
import {PessoaService} from "../service/pessoa.service";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    CadastroPessoaComponent,
    ListaPessoasComponent,
  ],
  exports: [
    CadastroPessoaComponent,
    ListaPessoasComponent,
  ],
  imports: [
    CommonModule
  ],
  providers: [
    PessoaService
  ]
})
export class ComponentModule{

}
