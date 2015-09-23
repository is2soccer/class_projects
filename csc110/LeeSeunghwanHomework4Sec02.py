# Project:      Homework4 (LeeSeunghwanHomework4Sec02.py)
# Name:         Seunghwan Lee
# Date:         02/26/14
# Description:  This program will calculate the total cost
#               of the coffee user needs

def intCheck(strQ):

    #Initialize boolean True to use while loop
    blnCheck = True

    #Using while looop, check user input
    while blnCheck:

        #Using try, except, print out error message if user does not put numbers
        try:
            intMethod = int(input(strQ))
            if intMethod == 1 or intMethod == 2 or intMethod == 3:
                blnCheck = False
            else:
                print("Error, Please choose (1/2/3)")
        except ValueError:
            print("Error, Please enter a number")
    return intMethod
        

def strState_check(strQ):

    #Using set, put data in one variable
    States = {'AL','AK','AZ','AR','CA','CO','CT','DE','FL','GA','HI','ID',
              'IL','IN','IN','IA','KS','KY','LA','ME','MD','MA','MI','MN',
              'MS','MO','MT','NE','NV','NH','NJ','NM','NY','NC','ND','OH',
              'OK','OR','PA','RI','SC','SD','TN','TX','UT','VT','VA','WA',
              'WV','WI','WY'}

    #Initialize boolean True to use while loop          
    blnCheck = True

    #Using while loop to check user input
    #If user input matches with "States", boolean change to False
    while blnCheck:
        strState = str.upper(input(strQ))
        if (strState in States) == True:
            blnCheck = False
        else:
            print("Error, Please enter right abbreviations of state")
    return strState
        

def fltWeight_check(strQ):

    #Initialize boolean True to use while loop
    blnCheck = True

    #Using while loop, check user input
    while blnCheck:

        #Using try, except, to print out error message
        try:
            fltWeight=float(input(strQ))
            if fltWeight > 0:
                blnCheck=False
            else:
                print("Error, Please enter over 0 pound")
        except ValueError:
            print("Error, Please enter a number")
    return fltWeight
            
def strCoffee_check(strQ):

    #Initialize boolean True to use while loop
    blnCheck = True

    #Using while loop, check user input
    while blnCheck:
        strCoffee = str.upper(input(strQ))
        if strCoffee == "JB" or strCoffee == "PJ":
            blnCheck = False
        else:
            print("Error!, Please enter JB or PJ")
    return strCoffee

def fltCalcCoffee(strCoffee, fltWeight, intPayment):

    #If user chose Jonestown Brew, multiply weight by 10.5
    if strCoffee == "JB":
        fltSubtotal = 10.5 * fltWeight

    #If user chose Plymouth Jolt, multiply weight by 16.95
    else:
        fltSubtotal = 16.95 * fltWeight


    #If user chose to pay with PayPal, take 3% commission
    if intPayment == 1:
        return round(fltSubtotal * 1.03, 2)

    #If user chose to pay with credit card, take 5% commission
    elif intPayment == 2:
        return round(fltSubtotal * 1.05, 2)

    #If user chose to pay with check, discount 2% off
    else:
        return round(fltSubtotal * 0.98, 2)
    
def fltCalcShipping(fltWeight, intMethod):

    #If user chose overnight(1), add $20 to the subtotal shipping cost
    if intMethod == 1:
        return round(fltWeight * 0.93 + 2.5 + 20, 2)

    #If user chose 2-Day Shipping(2), add $13 to the subtotal shipping cost
    elif intMethod == 2:
        return round(fltWeight * 0.93 + 2.5 + 13, 2)

    #If user chose standard(3), add none to the subtotal shipping cost
    else:
        return round(fltWeight * 0.93 + 2.5, 2)

def fltCalcTax(fltSubtotal, strState):

    #If user put "WA" or "CA", tax is 9%
    if strState == "WA" or strState == "CA":
        return round(fltSubtotal * 0.09, 2)

    #If user put "OR" or "FL", tax is none
    elif strState == "OR" or strState == "FL":
        return 0
    #If user put other states, tax is 7%
    else:
        return round(fltSubtotal * 0.07, 2)

def Total(strCoffee, fltWeight, strCity, strState, intMethod, intPayment):
    
    #Call the function to calculate the price of coffee
    fltCoffee = fltCalcCoffee(strCoffee, fltWeight, intPayment)

    #Call the function to calculate the shipping and handling cost
    fltShipping = fltCalcShipping(fltWeight, intMethod)

    #Call the function to calculate the tax
    fltTax = fltCalcTax(fltCoffee + fltShipping, strState)

    #To display the whole name, change abbreviation to the whole name
    if strCoffee == "JB":
        strCoffee = "Jonestown Brew"
    else:
        strCoffee = "Plymouth Jolt"

    #To display the type of payment, change the number to the type of payment    
    if intPayment == 1:
        strPayment = "PayPal with 3% commission"
    elif intPayment == 2:
        strPayment = "Credit Card with 5% commision"
    else:
        strPayment = "Check with 2% discount"

    #To display the shipping method, change the number to the shipping method    
    if intMethod == 1:
        strMethod = "Overnight"
    elif intMethod == 2:
        strMethod = "2-Day shipping"
    else:
        strMethod = "Standard"

    #Print out all the information and total
    print("=====================================")
    print("Product:",strCoffee)
    print("Weight:",fltWeight,"pounds")
    print("Payment type:",strPayment)
    print("Coffee cost: $"+str(fltCoffee))
    print("=====================================")
    print("Shipping method:",strMethod)
    print("Shipping and handling fee: $"+str(fltShipping))
    print("=====================================")
    print("Subtotal: $"+str(round(fltCoffee+fltShipping, 2)))
    print("Tax: $"+str(fltTax))
    print("Total: $"+str(round(fltCoffee+fltShipping+fltTax, 2)))
    print("=====================================")
    print("Destination: {0}, {1}".format(strCity, strState))
          
def main():

    #Greeting, and displaying the coffee price
    print("Welcome to The Konditorei coffee shop")
    print("================PRICE================")
    print(" Jonestown Brew (JB) = $10.50/pound")
    print(" Plymouth Jolt (PJ)  = $16.95/pound")
    print("=====================================")

    #Call the function to prompt user for type of coffee user needs and check input
    strCoffee = strCoffee_check("Enter type of coffee (JB/PJ): ")

    #Call the function to prompt user for weight of coffee user needs and check input
    fltWeight = fltWeight_check("Enter weight of coffee(lb): ")

    #Prompt user for the destination, city
    strCity = str.upper(input("Enter the city shipped: "))

    #Call the function to prompt user for the destination, state, and check input
    strState = strState_check("Enter the state shipped: ")

    #Display shipping method information
    print("============Shipping Method==========")
    print("              Overnight(1)")
    print("                2-Day(2)")
    print("               Standard(3)")
    print("=====================================")

    #Call the function to prompt user for a shipping method and check input
    intMethod = intCheck("Enter the shipping method(1/2/3): ")

    #Display payment type information
    print("=============Payment Type============")
    print("               PayPal(1)")
    print("             Credit Card(2)")
    print("               Check(3)")
    print("=====================================")

    #Call the function to prompt user for a type of payment and check input
    intPayment = intCheck("Enter the type of payment(1/2/3): ")

    #Call the function to print out total
    Total(strCoffee, fltWeight, strCity, strState, intMethod, intPayment)
    
main()
    
