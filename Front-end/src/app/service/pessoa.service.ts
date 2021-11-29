import {BaseCrudService} from "../base/base.crud.service";
import {Pessoa} from "../model/pessoa";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn:"root"
})
export class PessoaService extends BaseCrudService<Pessoa> {

  constructor(public http: HttpClient) {
    super(http, "/pessoa");
  }
}
