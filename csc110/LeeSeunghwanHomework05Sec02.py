# Project:      Homework05 (LeeSeunghwanHomework05Sec02.py)
# Name:         Seunghwan Lee
# Date:         03/07/14
# Description:  This program will allow the user to
#               test programs

from graphics import*
import random

def input_check(strInput,TextMessage):
    
    #Making sure user put the numbers inside of entry
    while True:
        try:
            return int(strInput.getText())

        #Instead of error message, Show error message I create
        except ValueError:
            TextMessage.setText("Please enter your guess number")


def drawDice(i,Dice,win):

    #Set the Dice background
    Box = Rectangle(Point(3.5+9*i,15.5),Point(10.5+9*i,22.5))
    Box.setFill('white')
    Box.draw(win)

    #Draw center dot
    if Dice != 2 and Dice != 4 and Dice != 6:
        Dot_Center = Circle(Point(7+9*i,19), 0.5)
        Dot_Center.setFill('black')
        Dot_Center.draw(win)

    #Draw topright and leftbottom dots
    if Dice != 1:
        Dot_Topright = Circle(Point(9+9*i,21), 0.5)
        Dot_Topright.setFill('black')
        Dot_Topright.draw(win)

        Dot_Leftbottom = Circle(Point(5+9*i,17), 0.5)
        Dot_Leftbottom.setFill('black')
        Dot_Leftbottom.draw(win)
                                
    #Draw Topleft and Rightbottom dots
    if Dice == 4 or Dice == 5 or Dice == 6:
        Dot_Topleft = Circle(Point(5+9*i,21), 0.5)
        Dot_Topleft.setFill('black')
        Dot_Topleft.draw(win)

        Dot_Rightbottom = Circle(Point(9+9*i,17), 0.5)
        Dot_Rightbottom.setFill('black')
        Dot_Rightbottom.draw(win)

    #Draw Leftcenter and Rightcenter dots
    if Dice ==6:
        Dot_Left = Circle(Point(5+9*i,19), 0.5)
        Dot_Left.setFill('black')
        Dot_Left.draw(win)

        Dot_Right = Circle(Point(9+9*i,19), 0.5)
        Dot_Right.setFill('black')
        Dot_Right.draw(win)
    

def main():

    #Set the window, coord, and backgraound
    win = GraphWin("Throw 5 dice", 500,300)
    win.setCoords(0.0, 0.0, 50, 30)
    win.setBackground('grey')

    #Set the Box for Entry so it looks better and clear
    Box_Entry = Rectangle(Point(30.5,25),Point(37.5,29))
    Box_Entry.setFill('black')
    Box_Entry.draw(win)

    #Set the text to indicate user to put the number on the right side
    Text(Point(20,27),"Enter your guess here").draw(win)

    #Set the entry where user can put the number
    strInput = Entry(Point(34,27), 5)
    strInput.setFill('white')
    strInput.draw(win)

    #Set the 5 boxes to throw the dice in
    Box1 = Rectangle(Point(3,15),Point(11,23))
    Box1.setOutline('white')
    Box1.setWidth(3)
    Box1.draw(win)
    
    Box2 = Rectangle(Point(12,15),Point(20,23))
    Box2.setOutline('white')
    Box2.setWidth(3)
    Box2.draw(win)
    
    Box3 = Rectangle(Point(21,15),Point(29,23))
    Box3.setOutline('white')
    Box3.setWidth(3)
    Box3.draw(win)
    
    Box4 = Rectangle(Point(30,15),Point(38,23))
    Box4.setOutline('white')
    Box4.setWidth(3)
    Box4.draw(win)
    
    Box5 = Rectangle(Point(39,15),Point(47,23))
    Box5.setOutline('white')
    Box5.setWidth(3)
    Box5.draw(win)

    #Set the box for user exit the program
    Box_Exit = Rectangle(Point(42,2),Point(49,5))
    Box_Exit.setFill('white')
    Box_Exit.setOutline('white')
    Box_Exit.draw(win)

    #Set the text "EXIT" inside of exit box
    Text_Exit = Text(Point(45.5,3.5),"EXIT")
    Text_Exit.draw(win)

    #Set the Text "DICE ()" inside of 5 dice boxes
    Text1 = Text(Point(7,19),"DICE 1")
    Text1.draw(win)
    
    Text2 = Text(Point(16,19),"DICE 2")
    Text2.draw(win)
    
    Text3 = Text(Point(25,19),"DICE 3")
    Text3.draw(win)
    
    Text4 = Text(Point(34,19),"DICE 4")
    Text4.draw(win)
    
    Text5 = Text(Point(43,19),"DICE 5")
    Text5.draw(win)

    #Set the text indicating user to find his guess number
    TextGuess = Text(Point(8,12),"Your Guess")
    TextGuess.draw(win)

    #Set the guess number empty first
    intGuess = Text(Point(8,10),"")
    intGuess.draw(win)

    #Set the text indicating user to find total dice sum
    TextTotal = Text(Point(20,12),"Dice Total")
    TextTotal.draw(win)

    #Set the number of sum of dice empty first.
    intTotal = Text(Point(20,10),"")
    intTotal.draw(win)

    #Set the first line message where I can put
    TextMessage = Text(Point(25,4),"")
    TextMessage.draw(win)

    #Set the second line message where I can put
    TextErrorMessage = Text(Point(25,2),"")
    TextErrorMessage.draw(win)

    #Initializing sum of dice
    Dicetotal = 0

    #Checking the input user put
    intInput = input_check(strInput,TextMessage)
   
    #Using loop, throw dice 5 times
    for i in range(5):

        #Set the boolean True
        blnCheck = True

        #Using while loop, make sure user click on the right space
        while blnCheck:

            #Get the value where user clicked
            Clicked = win.getMouse()
            xPoint = Clicked.getX()
            yPoint = Clicked.getY()

            #Get the number user guess, using other function
            intInput = input_check(strInput,TextMessage)
            
            #Let User only clicked on right space to proceed the program
            if 3+9*i<xPoint<11+9*i and 15<yPoint<23 and 5<=intInput<=30:
                blnCheck = False

                #Using random, we throw the dice
                Dice = random.randint(1,6)

                #Count the Dice total
                Dicetotal += Dice

                #In case, we had error message, set the text empty
                TextMessage.setText("")
                TextErrorMessage.setText("")
                
                intTotal.setText(Dicetotal)
                intGuess.setText(intInput)

                #Calling other function to draw dice
                drawDice(i,Dice,win)
                
            #Error message if user clicked on wrong space    
            else:
                TextMessage.setText("Clicked on the right space")
                TextErrorMessage.setText("Or enter the right guess(5~30)")


    #After throwing all the dice, show the result
    if Dicetotal - intInput == 0:
        TextMessage.setText("Your guess is right!!!")
    else:
        intDiff = ("{0} away from your guess".format(abs(Dicetotal-intInput)))
        TextMessage.setText("Your guess is wrong!")
        TextErrorMessage.setText(intDiff)

    #To finish the program get the x and y of mouse clicked
    Clicked_Exit = win.getMouse()
    xPoint_Exit = Clicked_Exit.getX()
    yPoint_Exit = Clicked_Exit.getY()
    
    #Let user close the program by clicking EXIT
    if 42<=xPoint_Exit<=49 and 2<=yPoint_Exit<=5:
        win.close()

    
        
main()
