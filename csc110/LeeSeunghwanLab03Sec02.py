# Project:      Homework1 (LeeSeunghwanLab03Sec02.py)
# Name:         Seunghwan Lee
# Date:         01/24/14
# Description:  This program will allow users to
#               calculate the total cost of an order


def input_check(strInput):
    #This checks user's input
    #If users do not put numbers, ask again
    while True:
        try:
            return float(input(strInput))
        except ValueError:
            print("Please type right numbers")
            

def Coffee():
    #Greeting
    print("Welcome, This program calculates the cost of an order.")
    print("------------------------------------------------------")

    #This lets users to put the weight of coffee
    fltWeight = input_check("How much does the coffee weight?(in pound): ")

    print("------------------------------------------------------")

    #This calculates the cost of product and shipping
    fltProductCost = fltWeight * 10.5
    fltShipping = fltWeight * 0.86 + 1.5

    #This calculates total cost
    fltTotal = fltProductCost + fltShipping

    #This changes float to string and display total cost on screen
    print("The total cost of the order is: $"+str(fltTotal))

Coffee()



def Average():
    #Greeting
    print("Welcome, This program finds the average of numbers users put")
    print("------------------------------------------------------------")

    #This prompt user to put how many numbers there are
    #   And calculates sum of numbers user puts
    fltSum = float(0)
    intNumber = int(input("How many numbers do you want to calculate?: "))
    for i in range(intNumber):
        fltNumber = input_check("Number: ")
        fltSum = fltSum + fltNumber
        
    #This print out the average
    print("The average of a series numbers is",fltSum)

Average()
