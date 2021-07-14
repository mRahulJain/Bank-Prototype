# ICIN Bank
It is a bank prototype that has <b>Angular frontend</b>, <b>Spring Boot API</b>, and <b>MySQL</b> backend. 
The whole application is containerized using <b>Docker</b> and its <b>Compose Files</b>.

## Features of the application
- Customer Portal
  - Registration
  - Login
  - Account transactions
  - Transfers
  - Savings details
  - Profile settings
  - Requesting cheque book
- Admin Portal
  - Login
  - Grant access to the user regarding transactions
  - Transfers
  - Block user in case of any threat
  - Grant permission to the user regarding cheque book requests

## Technologies Used
- Database management: MySQL
- Back-end logic: Java programming, SpringBoot framework
- Front-end development: Angular 2, HTML/CSS,
- DevOps and production technologies: Git, GitHub, and Docker

## How to run the application using Docker?
- Pull the docker images by running the following commands on your terminal
  - > docker pull mrahuljain/icin-bank:0.0.1.MYSQL
  - > docker pull mrahuljain/icin-bank:0.0.1.SPRINGBOOT
  - > docker pull mrahuljain/icin-bank:0.0.1.ANGULAR
- Open a terminal and change the directory to the project's base directory
- Run the following command on the terminal
  - > docker compose up
- To use the application, open a browser and type
  - http://localhost:4200/login


There are two accounts registered to the bank database (by-default) -

[
	{
		accountNumber: "123456789",
		accountHolderName: "Rahul Jain",
		accountCIFNumber: "ICIN0001",
		accountBranch: "NEW DELHI",
		accountIsNetBankingReg: 0,
		accountBalancePrimary: 1200.21,
		accountBalanceSavings: 5500.88
	},
	{
		accountNumber: "987654321",
		accountHolderName: "Akshat Bisht",
		accountCIFNumber: "ICIN0002",
		accountBranch: "Ghaziabad",
		accountIsNetBankingReg: 0,
		accountBalancePrimary: 2100.1,
		accountBalanceSavings: 9600.76
	}
]

Use these two accounts to play around with the application. 🤝