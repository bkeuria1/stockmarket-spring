export class TickerSummary{
    constructor(
        public ticker:string,
        public shares:number,
        public position:number,
        public currentPrice:number,
        public profit:number

    ){}
}
