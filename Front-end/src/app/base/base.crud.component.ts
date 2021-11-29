import {Directive, OnInit} from "@angular/core";

@Directive()
export class BaseCrudComponent<T> implements OnInit {

  ngOnInit(): void {
  }
}
