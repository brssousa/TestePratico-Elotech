import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CadastroPessoaComponent} from "./components/cadastro-pessoa/cadastro.pessoa.component";
import {ListaPessoasComponent} from "./components/lista-pessoas/lista.pessoas.component";

const routes: Routes = [
  {path:"cadastro-pessoa", component: CadastroPessoaComponent },
  {path:"lista-pessoas", component: ListaPessoasComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
