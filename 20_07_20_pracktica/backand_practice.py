from PIL import Image, ImageDraw
from math import *
import cv2
from matplotlib import pyplot as plt

def previtt(image_name):
    image = Image.open(image_name)
    image2 = Image.open(image_name)
    draw = ImageDraw.Draw(image2)
    width  = image.size[0]
    height = image.size[1]
    pix = image.load()
    for x in range(1,width-1):
        for y in range(1,height-1):
            z1 = pix[(x-1)%width, (y-1)%height][0]+pix[(x-1)%width, (y-1)%height][1]+pix[(x-1)%width, (y-1)%height][2]
            z2 = pix[x%width, (y-1)%height][0]+pix[x%width, (y-1)%height][1]+pix[x%width, (y-1)%height][2]
            z3 = pix[(x+1)%width, (y-1)%height][0]+pix[(x+1)%width, (y-1)%height][1]+pix[(x+1)%width, (y-1)%height][2]
            z4 = pix[(x-1)%width, y%height][0]+pix[(x-1)%width, y%height][1]+pix[(x-1)%width, y%height][2]
            z6 = pix[(x+1)%width, y%height][0]+pix[(x+1)%width, y%height][1]+pix[(x+1)%width, y%height][2]
            z7 = pix[(x-1)%width, (y+1)%height][0]+pix[(x-1)%width, (y+1)%height][1]+pix[(x-1)%width, (y+1)%height][2]
            z8 = pix[x%width, (y+1)%height][0]+pix[x%width, (y+1)%height][1]+pix[x%width, (y+1)%height][2]
            z9 = pix[(x+1)%width, (y+1)%height][0]+pix[(x+1)%width, (y+1)%height][1]+pix[(x+1)%width, (y+1)%height][2]
            Gx = (-z1-z2-z3+z7+z8+z9)/2
            Gy = (-z1-z4-z7+z3+z6+z9)/2
            G = round(sqrt(Gx**2+Gy**2))
            draw.point((x, y), (G, G, G))
    name = image_name.split(".")
    image2.save(name[0] + "_previtt" + "." + name[1])
    del draw

def sobel(image_name):
    image = Image.open(image_name)
    image2 = Image.open(image_name)
    draw = ImageDraw.Draw(image2)
    width  = image.size[0]
    height = image.size[1]
    pix = image.load()
    for x in range(1,width-1):
        for y in range(1,height-1):
            z1 = pix[(x-1)%width, (y-1)%height][0]+pix[(x-1)%width, (y-1)%height][1]+pix[(x-1)%width, (y-1)%height][2]
            z2 = pix[x%width, (y-1)%height][0]+pix[x%width, (y-1)%height][1]+pix[x%width, (y-1)%height][2]
            z3 = pix[(x+1)%width, (y-1)%height][0]+pix[(x+1)%width, (y-1)%height][1]+pix[(x+1)%width, (y-1)%height][2]
            z4 = pix[(x-1)%width, y%height][0]+pix[(x-1)%width, y%height][1]+pix[(x-1)%width, y%height][2]
            z6 = pix[(x+1)%width, y%height][0]+pix[(x+1)%width, y%height][1]+pix[(x+1)%width, y%height][2]
            z7 = pix[(x-1)%width, (y+1)%height][0]+pix[(x-1)%width, (y+1)%height][1]+pix[(x-1)%width, (y+1)%height][2]
            z8 = pix[x%width, (y+1)%height][0]+pix[x%width, (y+1)%height][1]+pix[x%width, (y+1)%height][2]
            z9 = pix[(x+1)%width, (y+1)%height][0]+pix[(x+1)%width, (y+1)%height][1]+pix[(x+1)%width, (y+1)%height][2]
            Gx = -z1-2*z2-z3+z7+2*z8+z9
            Gy = -z1-2*z4-z7+z3+2*z6+z9
            G = round(sqrt(Gx**2+Gy**2))
            draw.point((x, y), (G, G, G))
    name = image_name.split(".")
    image2.save(name[0] + "_sobel" + "." + name[1])
    del draw

def gauss_func(x,y,sigma):
    return exp(-(x**2+y**2)/(2*(sigma**2)))/(2*pi*(sigma**2))
def gauss(image_name,sigma):
    image = Image.open(image_name)
    image2 = Image.open(image_name)
    draw = ImageDraw.Draw(image2)
    width  = image.size[0]
    height = image.size[1]
    pix = image.load()
    b = []
    ceiled = ceil(sigma)
    for i in range(-2*ceiled,2*ceiled+1):
        b.append([])
        for j in range(-2*ceiled,2*ceiled+1):
            b[i+2*ceiled].append(gauss_func(i,j,sigma))
    for x in range(width):
        for y in range(height):
            sum_r = 0
            sum_g = 0
            sum_b = 0
            for i in range(-2*ceiled,2*ceiled+1):
                for j in range(-2*ceiled,2*ceiled+1):
                    sum_r += b[i+2*ceiled][j+2*ceiled]*pix[(x+j)%width, (y+i)%height][0]
                    sum_g += b[i+2*ceiled][j+2*ceiled]*pix[(x+j)%width, (y+i)%height][1]
                    sum_b += b[i+2*ceiled][j+2*ceiled]*pix[(x+j)%width, (y+i)%height][2]
            draw.point((x, y), (round(sum_r), round(sum_g), round(sum_b)))
    name = image_name.split(".")
    image2.save(name[0] + "_gauss" + "." + name[1])
    del draw

def med(image_name,k=2):
    image = Image.open(image_name)
    image2 = Image.open(image_name)
    draw = ImageDraw.Draw(image2)
    width  = image.size[0]
    height = image.size[1]
    pix = image.load()
    for x in range(width):
        for y in range(height):
            r = []
            g = []
            b = []
            for i in range(-k,k+1):
                for j in range(-k,k+1):
                    r.append(pix[(x+i)%width, (y+j)%height][0])
                    g.append(pix[(x+i)%width, (y+j)%height][1])
                    b.append(pix[(x+i)%width, (y+j)%height][2])
            aver = ceil(len(r)/2)
            medr = sorted(r)[aver]
            medg = sorted(g)[aver]
            medb = sorted(b)[aver]
            draw.point((x, y), (medr, medg, medb))
    name = image_name.split(".")
    image2.save(name[0] + "_med" + "." + name[1])
    del draw

def mean(image_name,k=2):
    image = Image.open(image_name)
    image2 = Image.open(image_name)
    draw = ImageDraw.Draw(image2)
    width  = image.size[0]
    height = image.size[1]
    pix = image.load()
    for x in range(width):
        for y in range(height):
            r = 0
            g = 0
            b = 0
            for i in range(-k,k+1):
                for j in range(-k,k+1):
                    r += pix[(x+i)%width, (y+j)%height][0]
                    g += pix[(x+i)%width, (y+j)%height][1]
                    b += pix[(x+i)%width, (y+j)%height][2]
            draw.point((x, y), (r//((2*k+1)**2), g//((2*k+1)**2), b//((2*k+1)**2)))
    name = image_name.split(".")
    image2.save(name[0] + "_mean" + "." + name[1])
    del draw

def shift(imagedata1, imagedata2):
    img1 = cv2.imread(imagedata1)
    img2 = cv2.imread(imagedata2)

    sift = cv2.xfeatures2d.SIFT_create()

    img1 = cv2.cvtColor(img1, cv2.COLOR_BGR2GRAY)
    img2 = cv2.cvtColor(img2, cv2.COLOR_BGR2GRAY)

    kp1, des1 = sift.detectAndCompute(img1, None)
    kp2, des2 = sift.detectAndCompute(img2, None)

    bf = cv2.BFMatcher()

    matches = bf.knnMatch(des1, des2, k=2)
    img1 = cv2.drawKeypoints(img1, kp1, img1)
    img2 = cv2.drawKeypoints(img2, kp2, img2)

    name1 = imagedata1.split(".")
    name2 = imagedata2.split(".")
    
    cv2.imwrite(name1[0] + '_shift' + "." + name1[1], img1)
    cv2.imwrite(name2[0] + '_shift' + "." + name2[1], img2)

    good = []
    for m, n in matches:
        if m.distance < 0.75 * n.distance:
            good.append([m])

    res = 'количество признаково у первого рисунка ' + str(len(des1)) + ' '
    res += '\nколичество признаково у второго рисунка ' + str(len(des2))
    res += '\nколичество общих признаков ' + str(len(good))
    return res