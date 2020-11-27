import { Observable } from 'rxjs';
import { ClientesService } from './../../clientes.service';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {

  cliente: Cliente;
  success: boolean = false;
  errors!: String[];
  id!: number;
  
  constructor( 
    private service: ClientesService, 
    private router: Router,
    private activeRouter: ActivatedRoute 
     ) { 
    this.cliente = new Cliente();
  }

  ngOnInit(): void {
    let params = this.activeRouter.params
    params.subscribe( urlParams => {
      this.id = urlParams['id']
      this.service.getClienteById(this.id).subscribe(
        response => this.cliente = response, 
        errorResponse => this.cliente = new Cliente())
    })
    
    }
  

  onSubmit(){
    if(this.id){
      this.service.atualizar(this.cliente)
      .subscribe(
        response => {
          this.success = true;
          this.errors = [];
        })
    }else{

      this.service.salvar(this.cliente)
      .subscribe( response => {
        this.success = true;
        this.errors = [];
        this.cliente = response;
      },
      errorResponse =>{
        this.success = false;
        this.errors = errorResponse.error.errors;
      }
      )}  
  }

  voltarParaListagem(){
    this.router.navigate(['/clientes/lista']);
  }

}
