export class Reporte {
    constructor(
        public anterior: number,
        public siguiente: number,
        public fin: boolean,
        public columnas?: any,
        public datos?: any,
    ) { }
}