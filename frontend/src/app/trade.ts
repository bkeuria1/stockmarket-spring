export class Trade {

    constructor(public id:number, public ticker:string, public currency:string, public shares:number,
                public price:number, public date:Date) {

    }
}
