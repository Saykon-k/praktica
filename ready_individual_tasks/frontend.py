from tkinter import *
from PIL import ImageTk, Image
from tkinter import filedialog
from backand_practice import *
from math import *
import os
root = Tk()
root.title("Обработка изображений")
root.geometry("1600x900")
root.resizable(width=False , height=False)
global  x
global  n
global sigma
global MeanBlurRadius
global MedianRadius
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
global swithcer_for_shift

swithcer_for_shift = -1
MedianRadius = 2
MeanBlurRadius = 2
sigma = 1
n = -1
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

global OpenImageButton
global SobelButton
global PrevittButton
global MedianBlurButton
global MeanBlurButton
global GaussBlurButton
global IncrementGaussButton
global DecrementGaussButton
global IncrementMeanBlurButton
global DecrementMeanBlureButton
global IncrementMedianBlurButton
global DecrementMedianBlurButton
global PicSaveAndReplaceButton
global ShowPicNowFullButton
global ShowPicResultFullButton
#function_for_treatment
def OpenImage():
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

def Sobel():
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

def Previtt():
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

def MedianBlur():
    global x
    global n
    global right_now_pic
    global panel
    global panel4
    if n == 3:
        med(x,MedianRadius)
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

def MeanBlur():
    global x
    global n
    global right_now_pic
    global panel
    global panel5
    if n == 4:
        mean(x,MeanBlurRadius)
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

def GaussBlur():
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

def IncrementGauss():
    global sigma
    if sigma < 5:
        sigma+=1

def DicrementGauss():
    global sigma
    if sigma > 1:
        sigma-=1

def IncrementMeanBlur():
    global MeanBlurRadius
    if MeanBlurRadius < 10:
        MeanBlurRadius+=1

def DecrementMeanBlure():
    global MeanBlurRadius
    if MeanBlurRadius > 2:
        MeanBlurRadius-=1

def IncrementMedianBlur():
    global MedianRadius
    if MedianRadius < 10:
        MedianRadius+=1

def DecrementMedianBlur():
    global MedianRadius
    if MedianRadius > 2:
        MedianRadius-=1

def DecrementMedianBlur():
    global MedianRadius
    if MedianRadius > 2:
        MedianRadius-=1

def PicSaveAndReplace():
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

def ShowPicNowFull():
    global x
    img = Image.open(x)
    img.show()

def ShowPicResultFull():
    global right_now_pic
    img = Image.open(right_now_pic)
    img.show()
#button_for_treatment
OpenImageButton = Button(text="Выберите изображение", command=OpenImage, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
OpenImageButton.pack()
OpenImageButton.place(x=165, y=105)

SobelButton = Button(text="Нахождение границ(Собель)", command=Sobel, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
SobelButton.pack()
SobelButton.place(x=0, y=735)

PrevittButton = Button(text="Нахождение границ(Превитт)", command=Previtt, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
PrevittButton.pack()
PrevittButton.place(x=0, y=680)

MedianBlurButton = Button(text="Размытие при помощи мединного значения", command=MedianBlur, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
MedianBlurButton.pack()
MedianBlurButton.place(x=680, y=680)

IncrementMedianBlurButton = Button(text="+(median)", command=IncrementMedianBlur, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
IncrementMedianBlurButton.pack()
IncrementMedianBlurButton.place(x=1030, y=735)

DecrementMedianBlurButton = Button(text="-(median)", command=DecrementMedianBlur(), background="#555",foreground="#ccc", padx="14", pady="7", font="13")
DecrementMedianBlurButton.pack()
DecrementMedianBlurButton.place(x=680, y=735)

MeanBlurButton = Button(text="Размытие при помощи среднего значения", command=MeanBlur, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
MeanBlurButton.pack()
MeanBlurButton.place(x=1150, y=680)

IncrementMeanBlurButton = Button(text="+(mean)", command=IncrementMeanBlur, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
IncrementMeanBlurButton.pack()
IncrementMeanBlurButton.place(x=1150, y=735)

DecrementMeanBlureButton = Button(text="-(mean)", command=DecrementMeanBlure, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
DecrementMeanBlureButton.pack()
DecrementMeanBlureButton.place(x=1150, y=790)

GaussBlurButton = Button(text="Размытие по Гауссу", background="#555",command=GaussBlur, foreground="#ccc", padx="14", pady="7", font="13")
GaussBlurButton.pack()
GaussBlurButton.place(x=370, y=680)

IncrementGaussButton = Button(text="+(Г)",command=IncrementGauss, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
IncrementGaussButton.pack()
IncrementGaussButton.place(x=518, y=735)

DecrementGaussButton = Button(text="-(Г)", command=DicrementGauss, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
DecrementGaussButton.pack()
DecrementGaussButton.place(x=370, y=735)

PicSaveAndReplaceButton = Button(text="Сохранение текущего результата и работа с ним",command=PicSaveAndReplace, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
PicSaveAndReplaceButton.pack()
PicSaveAndReplaceButton.place(x=955, y=105)

ShowPicNowFullButton = Button(text="Показать в полном размере", command=ShowPicNowFull, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
ShowPicNowFullButton.pack()
ShowPicNowFullButton.place(x=143, y=600)

ShowPicResultFullButton = Button(text="Показать в полном размере",command=ShowPicResultFull, background="#555", foreground="#ccc", padx="14", pady="7", font="13")
ShowPicResultFullButton.pack()
ShowPicResultFullButton.place(x=1053, y=600)

#find a piece function(not working)
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
    global swithcer_for_shift
    global for_rezim1
    global for_rezim2
    global res_sravn1
    global res_sravn2
    global laber_sravn3
    global laber_sravn4
    global srav_res_text

    if swithcer_for_shift == 1:
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

#find a piece button(working)
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
#next button switch  2 and forget all button
def switch_resim():
    global OpenImageButton
    global SobelButton
    global PrevittButton
    global MedianBlurButton
    global MeanBlurButton
    global GaussBlurButton
    global IncrementGaussButton
    global DecrementGaussButton
    global IncrementMeanBlurButton
    global DecrementMeanBlureButton
    global IncrementMedianBlurButton
    global DecrementMedianBlurButton
    global PicSaveAndReplaceButton
    global ShowPicNowFullButton
    global ShowPicResultFullButton
    global panel
    global panel2
    global panel3
    global panel4
    global panel5
    global panel6
    OpenImageButton.place_forget()
    SobelButton.place_forget()
    PrevittButton.place_forget()
    MedianBlurButton.place_forget()
    MeanBlurButton.place_forget()
    GaussBlurButton.place_forget()
    IncrementGaussButton.place_forget()
    DecrementGaussButton.place_forget()
    IncrementMeanBlurButton.place_forget()
    DecrementMeanBlureButton.place_forget()
    IncrementMedianBlurButton.place_forget()
    DecrementMedianBlurButton.place_forget()
    PicSaveAndReplaceButton.place_forget()
    ShowPicNowFullButton.place_forget()
    ShowPicResultFullButton.place_forget()
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
    global OpenImageButton
    global SobelButton
    global PrevittButton
    global MedianBlurButton
    global MeanBlurButton
    global GaussBlurButton
    global IncrementGaussButton
    global DecrementGaussButton
    global IncrementMeanBlurButton
    global DecrementMeanBlureButton
    global IncrementMedianBlurButton
    global DecrementMedianBlurButton
    global PicSaveAndReplaceButton
    global ShowPicNowFullButton
    global ShowPicResultFullButton
    global panel
    global panel2
    global panel3
    global panel4
    global panel5
    global panel6
    OpenImageButton.pack()
    OpenImageButton.place(x=165, y=105)
    SobelButton.pack()
    SobelButton.place(x=0, y=735)
    PrevittButton.pack()
    PrevittButton.place(x=0, y=680)
    MedianBlurButton.pack()
    MedianBlurButton.place(x=680, y=680)
    MeanBlurButton.pack()
    MeanBlurButton.place(x=1150, y=680)
    GaussBlurButton.pack()
    GaussBlurButton.place(x=370, y=680)
    IncrementGaussButton.pack()
    IncrementGaussButton.place(x=518, y=735)
    DecrementGaussButton.pack()
    DecrementGaussButton.place(x=370, y=735)
    IncrementMeanBlurButton.pack()
    IncrementMeanBlurButton.place(x=1150, y=735)
    DecrementMeanBlureButton.pack()
    DecrementMeanBlureButton.place(x=1150, y=790)
    IncrementMedianBlurButton.pack()
    IncrementMedianBlurButton.place(x=1030, y=735)
    DecrementMedianBlurButton.pack()
    DecrementMedianBlurButton.place(x=680, y=735)
    PicSaveAndReplaceButton.pack()
    PicSaveAndReplaceButton.place(x=955, y=105)
    ShowPicNowFullButton.pack()
    ShowPicNowFullButton.place(x=143, y=600)
    ShowPicResultFullButton.pack()
    ShowPicResultFullButton.place(x=1053, y=600)
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

switchrevim = Button(text="Сравнение фотографий",command=switch_resim, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
switchrevim.pack()
switchrevim.place(x=0, y=0)

switchrevim1 = Button(text="Обработка фотографий",command=switch_pokas, background="#555",foreground="#ccc", padx="14", pady="7", font="13")
switchrevim1.pack()
switchrevim1.place(x=1322, y=0)

btn18.place_forget()
btn19.place_forget()
btn20.place_forget()
btn21.place_forget()
btn22.place_forget()
btn23.place_forget()
btn24.place_forget()
OpenImageButton.place_forget()
SobelButton.place_forget()
PrevittButton.place_forget()
MedianBlurButton.place_forget()
MeanBlurButton.place_forget()
GaussBlurButton.place_forget()
IncrementGaussButton.place_forget()
DecrementGaussButton.place_forget()
IncrementMeanBlurButton.place_forget()
DecrementMeanBlureButton.place_forget()
IncrementMedianBlurButton.place_forget()
DecrementMedianBlurButton.place_forget()
PicSaveAndReplaceButton.place_forget()
ShowPicNowFullButton.place_forget()
ShowPicResultFullButton.place_forget()
root.mainloop()