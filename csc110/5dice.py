# Project:      5 Dice
# Name:         Seunghwan Lee
# Date:         02/26/14
# Description:  This program will draw 5 dices

#Import graphics
from graphics import *
def main():

    #Set the window
    win = GraphWin("5 Dice", 560, 120)

    #Using loop, set and draw Frames
    for i in range(5):
        Frame = Rectangle(Point(10*(1+i)+100*i,10),Point(110+10*i+100*i,110))
        Frame.setFill('white')
        Frame.draw(win)

    #Using loop, set and draw center dots
    for i in range(3):
        dot_center = Circle(Point(10*(1+i)+50+210*i,60),8)
        dot_center.setFill('black')
        dot_center.draw(win)

    #Using loop, set and draw top right dots
    for i in range(4):
        dot_topright = Circle(Point(120+(220/3)+110*i,10+80/3),8)
        dot_topright.setFill('black')
        dot_topright.draw(win)

    #Using loop, set and draw bottom left dots
    for i in range(4):
        dot_botleft = Circle(Point(120+(80/3)+110*i,10+(220/3)),8)
        dot_botleft.setFill('black')
        dot_botleft.draw(win)

    #Using loop, set and draw top left dots
    for i in range(2):
        dot_topleft = Circle(Point(340+(80/3)+110*i,10+(80/3)),8)
        dot_topleft.setFill('black')
        dot_topleft.draw(win)

    #Using loop, set and draw bottom right dots
    for i in range(2):
        dot_botright = Circle(Point(340+(220/3)+110*i,10+(220/3)),8)
        dot_botright.setFill('black')
        dot_botright.draw(win)

main()

    
