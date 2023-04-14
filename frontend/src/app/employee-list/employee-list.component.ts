import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../service/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent {

  employees: Employee[] = [];

  constructor(private api: EmployeeService, private router: Router){}
  
  ngOnInit()
  {
    this.getEmployees();
  }
  
  private getEmployees()
  {
    this.api.getEmployeeList().subscribe(
      data => 
      {
        this.employees = data;
      }
    );
  }

  updateEmployee(id: number)
  {
    this.router.navigate(['update-employee', id])
  }

  deleteEmployee(id: number)
  {
    this.api.deleteEmployee(id).subscribe(
      data=>
      {
        console.log(data);
        
        this.getEmployees();
      }
    )
  }

  detailsEmployee(id: number)
  {
    this.router.navigate(['employee-details', id]);
  }
}
