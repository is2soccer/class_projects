# Project:      Discussion 
# Name:         Khanh Tran
# Date:         02/26/14
# Description:  This program will create a graphic window that
#               draws 5 dice on the screen

from graphics import *

# define 'dots' function
def blackDot(center,win):
    blackdot=Circle(center,10)
    blackdot.draw(win)
    blackdot.setFill("Black")
    return blackdot
    
# define main function
def main():
    # create windows
    win = GraphWin("5 Dice",560,120)
    win.setBackground("white")

    # Use loop to create 5 dices without dot
    for rec in range(5):
        pointx = 100*rec + (10 * rec)
        rect = Rectangle(Point(pointx + 10,110),Point(pointx + 110,10))
        rect.draw(win)
        rect.setFill("white")

    # Use loop to create dot inside the dices
    for upright1 in range (4):
        pointx = 110 * upright1
        Dots = blackDot(Point(pointx + 200,30),win)
    for upright2 in range(2):
        pointx = 110 * upright2
        Dots = blackDot(Point(pointx + 360,30),win)
    for midpoint in range(3):
        pointx = 220 * midpoint
        Dots = blackDot(Point(pointx + 60,60),win)
    for bottom1 in range (4):
        pointx = 110 * bottom1
        Dots = blackDot(Point(pointx + 140,90),win)
    for bottom2 in range(2):
        pointx = 110 * bottom2
        Dots = blackDot(Point(pointx + 420 ,90),win)
# Call function     
main()
