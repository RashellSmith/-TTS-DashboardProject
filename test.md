I am having so trouble formatting my Reactive forms. I am getting data displayed through a service that I then set as the value form my form. The trouble I am having Is the form data is not formatted correctly so that It would be able to pass through to my back-end through my API. The formGroup is defined eailer in my html with ``` <form  [formGroup]="updateProduct" (ngSubmit)="onSubmit()">```<br>
The Json data should look like This:<br>
 ``` { "id": 1, "productName": "Scotch", "category": "Household", "fullPrice": 46.5, "salePrice": 35.26, "availability": true, "supplier": "Abbott Medical Optics, Inc.", "discount": "76%" }```



Form html:<br>
```
 <ng-container *ngIf="editMode === i">
          
          <td><input class="form-control"  formControlName="id"  disabled></td>
          <td><input class="form-control" id="productName"  formControlName="productName" ></td>
          <td >
              <select class="form-control" formGroupName="category" >
                <option selected="selcected"  id="opt1" ></option>
                <option *ngFor="let category of categories" [value]= "category">{{category}}</option>
              </select>
            </td>
          <td><input class="form-control" id="fullprice" formControlName="fullPrb nice"></td>
          <td><input class="form-control" id="saleprice"   formControlName="salePrice"></td>
          <td><input type="checkbox" class="form-control" id="availability"  formControlName="availability" ></td>
          <td>
            <select class="form-control" formGroupName="supplier" >
              <option *ngFor="let supplier of suppliers" [value]="supplier">{{supplier.supplierName}}</option>
            </select>
          </td>
          <td><input class="form-control" formControlName="discount" id="discount" ></td>
     
        </ng-container>
```

The method that set's my form values are in my subscribe method,so that form sets as soon as it's requested on click by a method in my ts file. <br>
```
this.homeService.getProduct(this.id).subscribe(data => {
  this.product = data;
  this.updateProduct.setValue({
    id: this.product.id,
    productName: this.product.productName,
    category: {
   // this.product.category.category is the category Id. same format as this.product.supplier.supplier
      category:this.product.category.category,
      CategoryName:this.product.category.categoryName
    },
    fullPrice: this.product.fullPrice,
    salePrice: this.product.salePrice,
    availability: this.product.availability,
    supplier:{
      supplier: this.product.supplier.supplier,
      supplierName:this.product.supplier.supplierName
    },
    discount: this.product.discount
  });
}); 
}
```

Ts.file that has my form: <br>
```
    updateProduct = new FormGroup({
      id: new FormControl(''),
      productName: new FormControl(''),
      category: new FormControl(''),
      fullPrice: new FormControl(''),
      salePrice: new FormControl(''),
      availability: new FormControl(''),
      supplier: new FormControl(''),
      discount: new FormControl(''),

    });
```

Currently my form data looks like this: <br>
```
{ "id": "", "productName": "", "category": { "category": "", "categoryName": "" }, "fullPrice": "", "salePrice": "", "availability": "", "supplier": { "supplier": "", "supplierName": "" }, "discount": "" }
```
It doesn't seem like it's registering my set values. I want to able to pass category as one value but that value is in a object this.product.category.category and this.product.category.categoryName as one form control through my selects. How would I register that as one form Control object 'category' in my form.