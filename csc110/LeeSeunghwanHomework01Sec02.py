# Project:      Homework1 (LeeSeunghwanHomework01Sec02.py)
# Name:         Seunghwan Lee
# Date:         01/13/14
# Description:  This program will allow users to
#               calculate the speed of bike
#               and allow users to put 2 numbers
#               and print out both numbers 6 times


def input_check(strInput):
    #This checks user's input
    #If users do not put numbers, ask again
    while True:
        try:
            return float(input(strInput))
        except ValueError:
            print("Please type in numbers")

    

def bike():
    print("Welcome, This program will calculate the speed of your bike.")
    print("------------------------------------------------------------")

    #This lets users to put their name.
    strName = str(input("What is your name?: "))
    
    print("--------------------------------------------------------")

    #This lets users to put distances in miles and times in minuts
    fltDistance = input_check("Please put the distance in miles: ")
    fltTime = input_check("Please put the time in minutes: ")
 
    #This converts time in minutes to time in hours
    fltTimeHour = float(fltTime * (1/60))

    #This calculates speeds of users' bike
    #   using distances in miles and times in hours
    fltSpeed = float(fltDistance/fltTimeHour)

    #This prints out results
    print("--------------------------------------------------------")
    print("If",strName,"has traveled",fltDistance,"miles and it took him")
    print(fltTime,"minutes he would traveling",fltSpeed,"Miles per Hour.")

bike()


def num():
    print("Now, please put 2 numbers you love.")
    print("-----------------------------------")

    #This lets users to put 2 numbers
    fltNum1 = input_check("please put the first number: ")
    fltNum2 = input_check("please put the second number: ")

    print("-----------------------------------")
    #This prints out both numbers 6 time using loop
    for i in range(6):
        print(fltNum1,"and",fltNum2)

num()
