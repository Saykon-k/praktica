from tkinter import *
from PIL import ImageTk, Image
from tkinter import filedialog
from backend_practice import *
from math import *
import os
root = Tk()
root.title("Обработка изображений")
root.geometry("1600x900")
root.resizable(width=False , height=False)
global  x
global  n
n = -1
global sigma
global mean_per
global men_per
global right_now_pic
global resim
global for_rezim1
global for_rezim2
global res_sravn1
global res_sravn2
global laber_obr
global laber_obr1
global panel
global panel2
global panel3
global panel4
global panel5
global panel6
global laber_sravn1
global laber_sravn2
global laber_sravn3
global laber_sravn4
global srav_res_text
global k
k = -1
men_per = 2
mean_per = 2
sigma = 1
def openfn_for_rezim():
    global for_rezim1
    global laber_sravn1
    for_rezim1 = openfn()
    img = Image.open(for_rezim1)
    img = img.resize((400, 400), Image.ANTIALIAS)
    img = ImageTk.PhotoImage(img)
    laber_sravn1.destroy()
    laber_sravn1 = Label(image=img)
    laber_sravn1.image = img
    laber_sravn1.pack()
    laber_sravn1.place(x=250, y=50)

def openfn_for_rezim2():
    global for_rezim2
    global laber_sravn2
    for_rezim2 = openfn()
    img = Image.open(for_rezim2)
    img = img.resize((400, 400), Image.ANTIALIAS)
    img = ImageTk.PhotoImage(img)
    laber_sravn2.destroy()
    laber_sravn2 = Label(image=img)
    laber_sravn2.image = img
    laber_sravn2.pack()
    laber_sravn2.place(x=1100, y=50)
def shift_fds():
    global k
    global for_rezim1
    global for_rezim2
    global res_sravn1
    global res_sravn2
    global laber_sravn3
    global laber_sravn4
    global srav_res_text

    if k == 1:
        prom = shift(for_rezim1,for_rezim2)
        name1 = for_rezim1.split(".")
        name2 = for_rezim2.split(".")

        first = name1[0] + '_shift' + "." + name1[1]
        second = name2[0] + '_shift' + "." + name2[1]

        res_sravn1 = first
        res_sravn2 = second

        first = Image.open(first)
        first = first.resize((400, 400), Image.ANTIALIAS)
        first = ImageTk.PhotoImage(first)
        laber_sravn3.destroy()
        laber_sravn3 = Label(image=first)
        laber_sravn3.image = first
        laber_sravn3.pack()
        laber_sravn3.place(x=250, y=500)

        second = Image.open(second)
        second = second.resize((400, 400), Image.ANTIALIAS)
        second = ImageTk.PhotoImage(second)
        laber_sravn4.destroy()
        laber_sravn4 = Label(image=second)
        laber_sravn4.image = second
        laber_sravn4.pack()
        laber_sravn4.place(x=1100, y=500)

        srav_res_text.destroy()
        srav_res_text = Label(text=prom)
        srav_res_text.pack()
        srav_res_text.place(x=800, y=0)
        k = -1
    k = 1
def openfn():
    filename = filedialog.askopenfilename(title='open')
    return filename
def open_img():
    global x
    global panel
    x = openfn()
    img = Image.open(x)
    img = img.resize((400, 400), Image.ANTIALIAS)
    img = ImageTk.PhotoImage(img)
    panel.destroy()
    panel = Label(image=img)
    panel.image = img
    panel.pack()
    panel.place(x=93,y=170)

def sobel_fun():
    global x
    global n
    global right_now_pic
    global panel
    global panel2
    if n == 1:
        sobel(x)
        name = x.split(".")
        right_now_pic = name[0] + "_sobel" + "." + name[1]
        img = Image.open(name[0] + "_sobel" + "." + name[1])
        img = img.resize((400, 400), Image.ANTIALIAS)
        img = ImageTk.PhotoImage(img)
        panel2.destroy()
        panel2 = Label(image=img)
        panel2.image = img
        panel2.pack()
        panel2.place(x=1000, y=170)
        n = -1
    n = 1
def previtt_fun():
    global x
    global n
    global right_now_pic
    global panel
    global panel3
    if n == 2:
        previtt(x)
        name = x.split(".")
        right_now_pic = name[0] + "_previtt" + "." + name[1]
        img = Image.open(name[0] + "_previtt" + "." + name[1])
        img = img.resize((400, 400), Image.ANTIALIAS)
        img = ImageTk.PhotoImage(img)
        panel3.destroy()
        panel3 = Label(image=img)
        panel3.image = img
        panel3.pack()
        panel3.place(x=1000, y=170)
        n = -1
    n = 2
def med_fun():
    global x
    global n
    global right_now_pic
    global panel
    global panel4
    if n == 3:
        med(x,men_per)
        name = x.split(".")
        right_now_pic =name[0] + "_med" + "." + name[1]
        img = Image.open(name[0] + "_med" + "." + name[1])
        img = img.resize((400, 400), Image.ANTIALIAS)
        img = ImageTk.PhotoImage(img)
        panel4.destroy()
        panel4 = Label(image=img)
        panel4.image = img
        panel4.pack()
        panel4.place(x=1000, y=170)
        n = -1
    n = 3
def mean_fun():
    global x
    global n
    global right_now_pic
    global panel
    global panel5
    if n == 4:
        mean(x,mean_per)
        name = x.split(".")
        right_now_pic =name[0] + "_mean" + "." + name[1]
        img = Image.open(name[0] + "_mean" + "." + name[1])
        img = img.resize((400, 400), Image.ANTIALIAS)
        img = ImageTk.PhotoImage(img)
        panel5.destroy()
        panel5 = Label(image=img)
        panel5.image = img
        panel5.pack()
        panel5.place(x=1000, y=170)
        n = -1
    n = 4
def gauss_fun():
    global x
    global n
    global sigma
    global right_now_pic
    global panel
    global panel6
    if n == 5:
        gauss(x,sigma)
        name = x.split(".")
        right_now_pic = name[0] + "_gauss" + "." + name[1]
        img = Image.open(name[0] + "_gauss" + "." + name[1])
        img = img.resize((400, 400), Image.ANTIALIAS)
        img = ImageTk.PhotoImage(img)
        panel6.destroy()
        panel6 = Label(image=img)
        panel6.image = img
        panel6.pack()
        panel6.place(x=1000, y=170)

        n = -1
    n = 5
def pic_change():
    global right_now_pic
    global x
    global panel
    x = right_now_pic
    img = Image.open(x)
    img = img.resize((400, 400), Image.ANTIALIAS)
    img = ImageTk.PhotoImage(img)
    panel.destroy()
    panel = Label(image=img)
    panel.image = img
    panel.pack()
    panel.place(x=93,y=170)

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

def show_pic2_orig():
    global for_rezim1
    img = Image.open(for_rezim1)
    img.show()

def show_pic2_cravn():
    global for_rezim2
    img = Image.open(for_rezim2)
    img.show()

def show_pic_obrabot():
    global res_sravn1
    img = Image.open(res_sravn1)
    img.show()

def show_pic_obrabot2():
    global res_sravn2
    img = Image.open(res_sravn2)
    img.show()


def switch_resim():
    global btn1
    global btn2
    global btn3
    global btn4
    global btn5
    global btn6
    global btn8
    global btn9
    global btn10
    global btn11
    global btn12
    global btn13
    global btn14
    global btn15
    global btn16
    global panel
    global panel2
    global panel3
    global panel4
    global panel5
    global panel6
    btn1.place_forget()
    btn2.place_forget()
    btn3.place_forget()
    btn4.place_forget()
    btn5.place_forget()
    btn6.place_forget()
    btn8.place_forget()
    btn9.place_forget()
    btn10.place_forget()
    btn11.place_forget()
    btn12.place_forget()
    btn13.place_forget()
    btn14.place_forget()
    btn15.place_forget()
    btn16.place_forget()
    panel.place_forget()
    panel2.place_forget()
    panel3.place_forget()
    panel4.place_forget()
    panel5.place_forget()
    panel6.place_forget()
    global btn18
    global btn19
    global btn20
    global btn21
    global btn22
    global btn23
    global btn24
    global laber_sravn1
    global laber_sravn2
    global laber_sravn3
    global laber_sravn4
    global srav_res_text
    btn18.pack()
    btn18.place(x=0, y=350)
    btn19.pack()
    btn19.place(x=900, y=350)
    btn20.pack()
    btn20.place(x=500, y=0)
    btn21.pack()
    btn21.place(x=0, y=300)
    btn22.pack()
    btn22.place(x=900, y=300)
    btn23.pack()
    btn23.place(x=0, y=600)
    btn24.pack()
    btn24.place(x=900, y=600)

    laber_sravn1.pack()
    laber_sravn1.place(x=250, y=50)
    laber_sravn2.pack()
    laber_sravn2.place(x=1100, y=50)
    laber_sravn3.pack()
    laber_sravn3.place(x=250, y=500)
    laber_sravn4.pack()
    laber_sravn4.place(x=1100, y=500)
    srav_res_text.pack()
    srav_res_text.place(x=800, y = 0 )
def switch_pokas():
    global btn1
    global btn2
    global btn3
    global btn4
    global btn5
    global btn6
    global btn8
    global btn9
    global btn10
    global btn11
    global btn12
    global btn13
    global btn14
    global btn15
    global btn16
    global panel
    global panel2
    global panel3
    global panel4
    global panel5
    global panel6
    btn1.pack()
    btn1.place(x=165, y=105)
    btn2.pack()
    btn2.place(x=0, y=735)
    btn3.pack()
    btn3.place(x=0, y=680)
    btn4.pack()
    btn4.place(x=680, y=680)
    btn5.pack()
    btn5.place(x=1150, y=680)
    btn6.pack()
    btn6.place(x=370, y=680)
    btn8.pack()
    btn8.place(x=518, y=735)
    btn9.pack()
    btn9.place(x=370, y=735)
    btn10.pack()
    btn10.place(x=1150, y=735)
    btn11.pack()
    btn11.place(x=1150, y=790)
    btn12.pack()
    btn12.place(x=1030, y=735)
    btn13.pack()
    btn13.place(x=680, y=735)
    btn14.pack()
    btn14.place(x=955, y=105)
    btn15.pack()
    btn15.place(x=143, y=600)
    btn16.pack()
    btn16.place(x=1053, y=600)
    panel.pack()
    panel.place(x=0,y=100)
    panel2.pack()
    panel2.place(x=1000, y=125)
    panel3.pack()
    panel3.place(x=1000, y=125)
    panel4.pack()
    panel4.place(x=1000, y=125)
    panel5.pack()
    panel5.place(x=1000, y=125)
    panel6.pack()
    panel6.place(x=1000, y=125)

    global btn18
    global btn19
    global btn20
    global btn21
    global btn22
    global btn23
    global btn24
    global laber_sravn1
    global laber_sravn2
    global laber_sravn3
    global laber_sravn4
    btn18.place_forget()
    btn19.place_forget()
    btn20.place_forget()
    btn21.place_forget()
    btn22.place_forget()
    btn23.place_forget()
    btn24.place_forget()
    laber_sravn1.place_forget()
    laber_sravn2.place_forget()
    laber_sravn3.place_forget()
    laber_sravn4.place_forget()
    srav_res_text.place_forget()
global btn1
global btn2
global btn3
global btn4
global btn5
global btn6
global btn8
global btn9
global btn10
global btn11
global btn12
global btn13
global btn14
global btn15
global btn16

btn1 = Button(text="Выберите изображение",command=open_img, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn1.pack()
btn1.place(x=165, y=105)

btn2 = Button(text="Нахождение границ(Собель)",command=sobel_fun, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn2.pack()
btn2.place(x=0, y=735)

btn3 = Button(text="Нахождение границ(Превитт)",command=previtt_fun, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn3.pack()
btn3.place(x=0, y=680)

btn4 = Button(text="Размытие при помощи мединного значения", command=med_fun,background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn4.pack()
btn4.place(x=680, y=680)

btn5 = Button(text="Размытие при помощи среднего значения",command=mean_fun ,background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn5.pack()
btn5.place(x=1150, y=680)

btn6 = Button(text="Размытие по Гауссу", background="#555",command=gauss_fun, foreground="#ccc", padx="14", pady="7", font="13")
btn6.pack()
btn6.place(x=370, y=680)


btn8 = Button(text="+(Г)",command=sigma_change_plus, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn8.pack()
btn8.place(x=518, y=735)

btn9 = Button(text="-(Г)",command=sigma_change_minus, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn9.pack()
btn9.place(x=370, y=735)

btn10 = Button(text="Прибавление mean размытие",command=mean_per_change_plus, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn10.pack()
btn10.place(x=1150, y=735)

btn11 = Button(text="-(mean)",command=mean_per_change_minus, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn11.pack()
btn11.place(x=1150, y=790)

btn12 = Button(text="+(med)",command=men_per_change_plus, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
btn12.pack()
btn12.place(x=1030, y=735)

btn13 = Button(text="-(med)",command=men_per_change_minus, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn13.pack()
btn13.place(x=680, y=735)

btn14 = Button(text="Сохранение текущего результата и работа с ним",command=pic_change, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn14.pack()
btn14.place(x=955, y=105)

btn15 = Button(text="Показать в полном размере",command=show_pic_orig, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn15.pack()
btn15.place(x=143, y=600)

btn16 = Button(text="Показать в полном размере",command=show_pic_tek, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn16.pack()
btn16.place(x=1053, y=600)



btn1.place_forget()
btn2.place_forget()
btn3.place_forget()
btn4.place_forget()
btn5.place_forget()
btn6.place_forget()
btn8.place_forget()
btn9.place_forget()
btn10.place_forget()
btn11.place_forget()
btn12.place_forget()
btn13.place_forget()
btn14.place_forget()
btn15.place_forget()
btn16.place_forget()


switchrevim = Button(text="Сравнение фотографий",command=switch_resim, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
switchrevim.pack()
switchrevim.place(x=0, y=0)

switchrevim1 = Button(text="Обработка фотографий",command=switch_pokas, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
switchrevim1.pack()
switchrevim1.place(x=1322, y=0)

btn18 = Button(text="Загрузка фотки первой",command=openfn_for_rezim, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn18.pack()
btn18.place(x=0, y=350)

btn19 = Button(text="Загрузка фотки второй",command=openfn_for_rezim2, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn19.pack()
btn19.place(x=900, y=350)

btn20 = Button(text="shift",command=shift_fds, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn20.pack()
btn20.place(x=700, y=0)

btn21 = Button(text="Показать в оригинале",command=show_pic2_orig, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn21.pack()
btn21.place(x=0, y=300)


btn22 = Button(text="Показать в оригинале",command=show_pic2_cravn, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn22.pack()
btn22.place(x=900, y=300)

btn23 = Button(text="Показать в оригинале",command=show_pic_obrabot, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn23.pack()
btn23.place(x=0, y=600)

btn24 = Button(text="Показать в оригинале",command=show_pic_obrabot2, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
btn24.pack()
btn24.place(x=900, y=600)

btn18.place_forget()
btn19.place_forget()
btn20.place_forget()
btn21.place_forget()
btn22.place_forget()
btn23.place_forget()
btn24.place_forget()

panel = Label()
panel2 = Label()

panel3 = Label()
panel4 = Label()

panel5 = Label()
panel6 = Label()

laber_sravn1 = Label()
laber_sravn2 = Label()
laber_sravn3 = Label()
laber_sravn4 = Label()
laber_obr = Label()
laber_obr1 = Label()
srav_res_text = Label()

root.mainloop()