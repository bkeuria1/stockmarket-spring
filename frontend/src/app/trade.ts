export class Trade {

    constructor(public ticker:string, public currency:string, public shares:number,
                public price:number, public date:Date, public buying:boolean) {
    }
}
