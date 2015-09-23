# Project:      Homework 06 (LeeSeunghwanHomework06Sec02.py)
# Name:         Seunghwan Lee
# Date:         03/19/14
# Description:  This program will import data, family information
#               And report 4 informations



#Import graphics
from graphics import*

#Call Report1 Function
def Report1(Master):

    #Set outfile to create new txt file
    outfile = open("Lee_Seunghwan_report01.txt", 'w')

    #Using loop in range of number of list
    for i in range(len(Master[0])):

        #If state is Alaska and income is below the poverty level, write on outfile
        if Master[3][i] == "AK" and 7650 + 3980 * int(Master[1][i]) > int(Master[2][i]):
            print((Master[0][i]),(Master[1][i]),(Master[2][i]),(Master[3][i]), file=outfile)

        #If state is Hawaii and income is below the poverty level, write on outfile    
        elif Master[3][i] == "HI" and 7040 + 3660 * int(Master[1][i]) > int(Master[2][i]):
            print((Master[0][i]),(Master[1][i]),(Master[2][i]),(Master[3][i]), file=outfile)

        #If state is not Alaska nor Hawaii and income is below the poverty level, write on outfile
        elif Master[3][i] != "AK" and Master[3][i] != "HI" and 6130 + 3180 * int(Master[1][i]) > int(Master[2][i]):
            print((Master[0][i]),(Master[1][i]),(Master[2][i]),(Master[3][i]), file=outfile)
        
#Call Report4 Function
def Report4(Master):

    #Set outfile to create new txt file
    outfile = open("Lee_Seunghwan_report04.txt", 'w')

    #Using loop in range of number of list
    for i in range(len(Master[0])):

        #If state is Alaska and income is below the poverty level, write and add "Y" on outfile
        #By adding Y and N, Y means it's below the poverty level and N means it's above the poverty level
        if Master[3][i] == "AK" and 7650 + 3980 * int(Master[1][i]) > int(Master[2][i]):
            print((Master[0][i]),(Master[1][i]),(Master[2][i]),(Master[3][i]),"Y", file=outfile)

        #If state is Hawaii and income is below the poverty level, write and add "Y" on outfile
        elif Master[3][i] == "HI" and 7040 + 3660 * int(Master[1][i]) > int(Master[2][i]):
            print((Master[0][i]),(Master[1][i]),(Master[2][i]),(Master[3][i]),"Y", file=outfile)

        #If state is not Alaska nor Hawaii, and income is below the poverty level, write and add "Y" on outfile
        elif Master[3][i] != "AK" and Master[3][i] != "HI" and 6130 + 3180 * int(Master[1][i]) > int(Master[2][i]):
            print((Master[0][i]),(Master[1][i]),(Master[2][i]),(Master[3][i]),"Y", file=outfile)

        #Else, write and add "N" on outfile
        else:
            print((Master[0][i]),(Master[1][i]),(Master[2][i]),(Master[3][i]),"N", file=outfile)
            
#Call Report2 Function
def Report2(Master,Text_data):

    #Create list
    Family = []

    #Initiate the income total
    intIncome_Total = 0

    #Using loop in range of number of list
    for i in range(len(Master[0])):

        #Calculate sum of incomes
        intIncome_Total += int(Master[2][i])

    #Calculate the income average
    fltIncome_Ave = intIncome_Total/len(Master[0])

    #Using loop in range of number of list
    for i in range(len(Master[0])):

        #If income is above the average income, save family ID on family
        if int(Master[2][i]) > fltIncome_Ave:
            Family.append(Master[0][i])

    #Display the family id above the the average income           
    Text_data.setText("The families above the average income are below(ID)\n{0}".format(", ".join(Family)))

#Call Report3 Function
def Report3(Master,Text_data):

    #Initiate counter
    intCount = 0

    #Using loop in range of number of list
    for i in range(len(Master[0])):

        #If state is Alaska and income is below the poverty level, add 1 to counter
        if Master[3][i] == "AK" and 7650 + 3980 * int(Master[1][i]) > int(Master[2][i]):
            intCount += 1

        #If state is Hawaii and income is below the poverty level, add 1 to counter
        elif Master[3][i] == "HI" and 7040 + 3660 * int(Master[1][i]) > int(Master[2][i]):
            intCount += 1

        #If state is not Alaska nor Hawaii and income is below the poverty level, add 1 to counter
        elif Master[3][i] != "AK" and Master[3][i] != "HI" and 6130 + 3180 * int(Master[1][i]) > int(Master[2][i]):
            intCount += 1

    #Display % data of mailies that fall below the poverty level
    Text_data.setText("The % of families that fall below the poverty level is "+ str(round((intCount/len(Master[0])) * 100,2))+"%")
    
def main():

    #Create the window and set the size and coords
    win = GraphWin("Family Income Report", 800,500)
    win.setCoords(0,0,100,100)
    win.setBackground('white')

    #Create the Box for Import button
    Box_Import = Rectangle(Point(10,90),Point(45,80))
    Box_Import.setFill('grey')
    Box_Import.draw(win)

    #Create the text for Import button
    Text_0 = Text(Point(27.5,85),"Import Files")
    Text_0.setSize(10)
    Text_0.draw(win)

    #Create the text for import success
    Text_Import = Text(Point(67.5,85),"")
    Text_Import.draw(win)

    #Create the box and the text for report 1 button
    Box_1 = Rectangle(Point(10,70),Point(25,60))
    Box_1.draw(win)
    Text_1 = Text(Point(17.5,65),"REPORT 1")
    Text_1.setSize(7)
    Text_1.draw(win)

    #Create the box and the text for report 2 button
    Box_2 = Rectangle(Point(30,70),Point(45,60))
    Box_2.draw(win)
    Text_2 = Text(Point(37.5,65),"REPORT 2")
    Text_2.setSize(7)
    Text_2.draw(win)

    #Create the box and the text for report 3 button
    Box_3 = Rectangle(Point(50,70),Point(65,60))
    Box_3.draw(win)
    Text_3 = Text(Point(57.5,65),"REPORT 3")
    Text_3.setSize(7)
    Text_3.draw(win)

    #Create the box and the text for report 4 button
    Box_4 = Rectangle(Point(70,70),Point(85,60))
    Box_4.draw(win)
    Text_4 = Text(Point(77.5,65),"REPORT 4")
    Text_4.setSize(7)
    Text_4.draw(win)

    #Create the box and the text for EXIT button
    Box_Exit = Rectangle(Point(85,10),Point(95,5))
    Box_Exit.draw(win)
    Text(Point(90,7.5),"EXIT").draw(win)

    #Create the text for report result
    Text_data = Text(Point(50,30),"")
    Text_data.draw(win)

    #Create the Lists to save the information
    Master = []
    Id = []
    Member = []
    Income = []
    State = []

    #Set the boolean true
    bln = True

    #Using loop let user push IMPORT button or EXIT button
    while bln:

        #Get the x and y where user clicked
        Clicked = win.getMouse()
        xPoint = Clicked.getX()
        yPoint = Clicked.getY()

        #If user pushed EXIT button, boolean changes to false and close program
        if 85<xPoint<95 and 5<yPoint<10:
            bln = False
            win.close()

        #If user pushed IMPORT button, import "input file.txt"
        elif 10<xPoint<45 and 80<yPoint<90:
            infile = open("input file.txt", 'r')
            Text_Import.setText("Import Success!")
            Text_data.setText("")

            #Using loop, split every line
            for line in infile:
                strId, strMember, strIncome, strState = line.split()

                #Save each information in each list
                Id.append(strId)
                Member.append(strMember)
                Income.append(strIncome)
                State.append(strState)
                
            #Close the file we imported    
            infile.close()

            #Put every list in one master list
            Master.append(Id)
            Master.append(Member)
            Master.append(Income)
            Master.append(State)

            #Set the boolean False
            bln = False

            #Set another boolean True
            blnReport = True

            #Using while loop, let user use report button
            while blnReport:

                #Get x and y where user clicked
                Clicked = win.getMouse()
                xPoint = Clicked.getX()
                yPoint = Clicked.getY()

                #If user pushed EXIT button, boolean changes to false
                if 85<xPoint<95 and 5<yPoint<10:
                    blnReport = False

                #If user pushed REPORT 1 button, call Report1 function
                elif 10<xPoint<25 and 60<yPoint<70:
                    Report1(Master)

                    #Display that report 1 success
                    Text_data.setText("Report 1 Success")

                #If user pushed REPORT 4 button, call Report4 function
                elif 70<xPoint<85 and 60<yPoint<70:
                    Report4(Master)

                    #Display that report 4 success
                    Text_data.setText("Report 4 Success")

                #If user pushed REPORT 2 button, call Report2 function
                elif 30<xPoint<45 and 60<yPoint<70:
                    Report2(Master,Text_data)

                #If user pushed REPORT 3 button, call Report3 function
                elif 50<xPoint<65 and 60<yPoint<70:
                    Report3(Master,Text_data)

               

                #If user pushed wrong area, display error message        
                else:
                    Text_data.setText("Please click Report 1-4")

        #If user pushed wrong area, show error message
        else:
            Text_data.setText("Please import file!")

    #Close window       
    win.close()
            
        
    
main()
