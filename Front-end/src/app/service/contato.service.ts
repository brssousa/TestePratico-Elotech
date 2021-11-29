import {Injectable} from "@angular/core";
import {BaseCrudService} from "../base/base.crud.service";
import {HttpClient} from "@angular/common/http";
import {Contato} from "../model/contato";

@Injectable({
  providedIn:"root"
})
export class ContatoService extends BaseCrudService<Contato> {

  constructor(public http: HttpClient) {
    super(http, "/contato");
  }
}
