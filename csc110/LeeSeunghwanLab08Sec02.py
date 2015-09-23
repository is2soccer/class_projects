# Project:      Lab 08 (LeeSeunghwanLab08Sec02.py)
# Name:         Seunghwan Lee
# Date:         02/27/14
# Description:  This program will let user enter
#               5 test scores and draw graphs

#Import graphics
from graphics import *

def graphs(intScore1,intScore2,intScore3,intScore4,intScore5):
    
    #Set the window to draw graphs in
    win = GraphWin("Test Scores",450,300)

    #Set the backgraound of window
    win.setBackground('yellow')

    #Draw text "0~100" scales in window
    Text(Point(20,290),"0").draw(win)
    Text(Point(60,290),"10").draw(win)
    Text(Point(100,290),"20").draw(win)
    Text(Point(140,290),"30").draw(win)
    Text(Point(180,290),"40").draw(win)
    Text(Point(220,290),"50").draw(win)
    Text(Point(260,290),"60").draw(win)
    Text(Point(300,290),"70").draw(win)
    Text(Point(340,290),"80").draw(win)
    Text(Point(380,290),"90").draw(win)
    Text(Point(420,290),"100").draw(win)

    #Set graphs in the window with each different collor
    #And Each graph shows each scores
    Bar5 = Rectangle(Point(20,270),Point(20+4*intScore5,240))
    Bar5.setFill('red')
    Bar4 = Rectangle(Point(20,230),Point(20+4*intScore4,200))
    Bar4.setFill('green')
    Bar3 = Rectangle(Point(20,190),Point(20+4*intScore3,160))
    Bar3.setFill('white')
    Bar2 = Rectangle(Point(20,150),Point(20+4*intScore2,120))
    Bar2.setFill('black')
    Bar1 = Rectangle(Point(20,110),Point(20+4*intScore1,80))
    Bar1.setFill('Orange')

    #Now, draw all graphs in the window
    Bar1.draw(win)
    Bar2.draw(win)
    Bar3.draw(win)
    Bar4.draw(win)
    Bar5.draw(win)

    #Display text on the top center
    Text(Point(225,20),"5 Test Scores").draw(win)

    #Let user exit by push enter
    input("Press <Enter> to quit")
    win.close()

def main():

    #Greeting
    print("Welcome, This program draws graphs of your 5 test score")

    #Prompt user for 5 test scores
    intScore1 = int(input("Enter the first test score: "))
    intScore2 = int(input("Enter the second test score: "))
    intScore3 = int(input("Enter the third test score: "))
    intScore4 = int(input("Enter the fourth test score: "))
    intScore5 = int(input("Enter the fifth test score: "))

    #Call other function to display graphs
    graphs(intScore1,intScore2,intScore3,intScore4,intScore5)

main()
