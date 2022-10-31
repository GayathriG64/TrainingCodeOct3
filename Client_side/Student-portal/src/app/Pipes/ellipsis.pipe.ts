import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ellipsis'
})
export class EllipsisPipe implements PipeTransform {

  transform(value: String, ...args: String[]): unknown {

    if(value.length>20){
      return value.substring(0,20)+"...."
    }
    return value;
  }

}
