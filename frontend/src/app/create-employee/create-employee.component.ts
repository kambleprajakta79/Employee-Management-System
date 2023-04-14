import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../service/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent {

  employee: Employee = new Employee();

  constructor(private api: EmployeeService, private router : Router){}

  saveEmployee()
  {
    this.api.createEmployee(this.employee).subscribe(
      (data: any) =>
      {
        this.goToEmployeeList(); 
      },
      (error : any) =>
      {
        console.log(error);
      }
    )
  }


  goToEmployeeList()
  {
    this.router.navigate(['./employees']);
  }


  onSubmit()
  {
    console.log(this.employee);
    this.saveEmployee();
    
  }

  

}
