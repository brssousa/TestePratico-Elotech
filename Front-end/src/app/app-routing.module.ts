import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CadastroPessoaComponent} from "./components/cadastro-pessoa/cadastro.pessoa.component";
import {ListaPessoasComponent} from "./components/lista-pessoas/lista.pessoas.component";
import {CadastroContatoComponent} from "./components/cadastro-contato/cadastro.contato.component";

const routes: Routes = [
  {path:"cadastro-pessoa", component: CadastroPessoaComponent },
  {path:"cadastro-contato", component: CadastroContatoComponent },
  {path:"lista-pessoas", component: ListaPessoasComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
