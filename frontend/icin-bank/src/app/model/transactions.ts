export interface Transactions {
    id: number,
    fromAccountNumber: string,
    toAccountNumber: string,
    fromAccountHolderName: string,
    toAccountHolderName: string,
    fromAccountType: string,
    toAccountType: string,
    transferAmount: number,
    transferMessage: string,
    transferType: string,
    transferDate: string,
    transferStatus: number
}
