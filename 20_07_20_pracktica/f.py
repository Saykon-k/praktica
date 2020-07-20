from tkinter import *
from PIL import ImageTk, Image
from tkinter import filedialog
from backand_practice import *
import os
root = Tk()
root.title("GUI на Python")
root.geometry("1280x720")
root.resizable(width=True , height=True)
global  x
global  n
n = -1
global sigma
global mean_per
global men_per
global right_now_pic
men_per = 2
mean_per = 2
sigma = 1
def openfn():
    filename = filedialog.askopenfilename(title='open')
    return filename
def open_img():
    global x
    x = openfn()
    img = Image.open(x)
    img = img.resize((400, 400), Image.ANTIALIAS)
    img = ImageTk.PhotoImage(img)
    panel = Label(image=img)
    panel.image = img
    panel.place(x=0,y=100)

def sobel_fun():
    global x
    global n
    global right_now_pic
    if n == 1:
        sobel(x)
        right_now_pic = x[:-4] + "_sobel" + x[-4:]
        img = Image.open(x[:-4] + "_sobel" + x[-4:])
        img = img.resize((400, 400), Image.ANTIALIAS)
        img = ImageTk.PhotoImage(img)
        panel = Label(image=img)
        panel.image = img
        panel.place(x=600, y=100)
        n = -1
    n = 1
def previtt_fun():
    global x
    global n
    global right_now_pic
    if n == 2:
        previtt(x)
        right_now_pic = x[:-4] + "_previtt" + x[-4:]
        img = Image.open(x[:-4] + "_previtt" + x[-4:])
        img = img.resize((400, 400), Image.ANTIALIAS)
        img = ImageTk.PhotoImage(img)
        panel = Label(image=img)
        panel.image = img
        panel.place(x=600, y=100)
        n = -1
    n = 2
def med_fun():
    global x
    global n
    global right_now_pic
    if n == 3:
        med(x,men_per)
        right_now_pic = x[:-4] + "_med" + x[-4:]
        img = Image.open(x[:-4] + "_med" + x[-4:])
        img = img.resize((400, 400), Image.ANTIALIAS)
        img = ImageTk.PhotoImage(img)
        panel = Label(image=img)
        panel.image = img
        panel.place(x=600, y=100)
        n = -1
    n = 3
def mean_fun():
    global x
    global n
    global right_now_pic
    if n == 4:
        mean(x,mean_per)
        right_now_pic = x[:-4] + "_mean" + x[-4:]
        img = Image.open(x[:-4] + "_mean" + x[-4:])
        img = img.resize((400, 400), Image.ANTIALIAS)
        img = ImageTk.PhotoImage(img)
        panel = Label(image=img)
        panel.image = img
        panel.place(x=600, y=100)
        n = -1
    n = 4
def gauss_fun():
    global x
    global n
    global sigma
    global right_now_pic
    if n == 5:
        gauss(x,sigma)
        right_now_pic = x[:-4] + "_gauss" + x[-4:]
        img = Image.open(x[:-4] + "_gauss" + x[-4:])
        img = img.resize((400, 400), Image.ANTIALIAS)
        img = ImageTk.PhotoImage(img)
        panel = Label(image=img)
        panel.image = img
        panel.place(x=600, y=100)
        n = -1
    n = 5
def pic_change():
    global right_now_pic
    global x
    x = right_now_pic
    img = Image.open(x)
    img = img.resize((400, 400), Image.ANTIALIAS)
    img = ImageTk.PhotoImage(img)
    panel = Label(image=img)
    panel.image = img
    panel.place(x=0, y=100)

def show_pic_orig():
    global x
    img = Image.open(x)
    img.show()

def show_pic_tek():
    global right_now_pic
    img = Image.open(right_now_pic)
    img.show()

def sigma_change_plus():
    global sigma
    if sigma < 5:
        sigma+=1
def sigma_change_minus():
    global sigma
    if sigma > 1:
        sigma-=1


def mean_per_change_plus():
    global mean_per
    if mean_per < 10:
        mean_per+=1
def mean_per_change_minus():
    global mean_per
    if mean_per > 2:
        mean_per-=1


def men_per_change_plus():
    global men_per
    if men_per < 10:
        men_per+=1

def men_per_change_minus():
    global men_per
    if men_per > 2:
        men_per-=1

btn1 = Button(text="Выберите изображение",command=open_img, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn1.place(x=50, y=500)
 
btn2 = Button(text="Нахождение границ(Собель)",command=sobel_fun, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn2.place(x=0, y=600)
 
btn3 = Button(text="Нахождение границ(Превитт)",command=previtt_fun, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn3.place(x=0, y=650)

btn2 = Button(text="Размытие при помощи мединного значения", command=med_fun,background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn2.place(x=250, y=600)

btn3 = Button(text="Размытие при помощи среднего значения",command=mean_fun ,background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn3.place(x=250, y=650)

btn4 = Button(text="Размытие по Гауссу", background="#555",command=gauss_fun, foreground="#ccc", padx="14", pady="7", font="13")
btn4.place(x=600, y=650)

btn4 = Button(text="Размытие по Гауссу", background="#555",command=gauss_fun, foreground="#ccc", padx="14", pady="7", font="13")
btn4.place(x=600, y=650)

btn5 = Button(text="Прибавление размытия(Гаусса)",command=sigma_change_plus, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn5.place(x=600, y=0)

btn6 = Button(text="Уменьшение размытия(Гаусса)",command=sigma_change_minus, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn6.place(x=900, y=0)

btn7 = Button(text="Прибавление mean размытие",command=mean_per_change_plus, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn7.place(x=600, y=60)

btn8 = Button(text="Уменьшение mean размытие",command=mean_per_change_minus, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn8.place(x=900, y=60)

btn9 = Button(text="Прибавление men размытие",command=men_per_change_plus, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn9.place(x=600, y=700)

btn10 = Button(text="Уменьшение men размытие",command=men_per_change_minus, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn10.place(x=900, y=700)

btn11 = Button(text="Сохранение текущего результата и работа с ним",command=pic_change, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn11.place(x=900, y=1000)


btn12 = Button(text="Показать в полном размере",command=show_pic_orig, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn12.place(x=0, y=550)

btn13 = Button(text="Показать в полном размере",command=show_pic_tek, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn13.place(x=600, y=550)


root.mainloop()