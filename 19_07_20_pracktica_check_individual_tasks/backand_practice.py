from PIL import Image, ImageDraw
from math import *
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
    image2.save(image_name[:-4] + "_previtt" + image_name[-4:])
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
    image2.save(image_name[:-4] + "_sobel" + image_name[-4:])
    del draw

def gauss_func(x,y,sigma):
    return exp(-(x**2+y**2)/(2*(sigma**2)))/(2*pi*(sigma**2))
def gauss(image_name):
    image = Image.open(image_name)
    image2 = Image.open(image_name)
    draw = ImageDraw.Draw(image2)
    width  = image.size[0]
    height = image.size[1]
    pix = image.load()
    b = []
    for i in range(-4,5):
        b.append([])
        for j in range(-4,5):
            b[i+4].append(gauss_func(i,j,2))
    for x in range(width):
        for y in range(height):
            sum_r = 0
            sum_g = 0
            sum_b = 0
            for i in range(-4,5):
                for j in range(-4,5):
                    sum_r += b[i+4][j+4]*pix[(x+j)%width, (y+i)%height][0]
                    sum_g += b[i+4][j+4]*pix[(x+j)%width, (y+i)%height][1]
                    sum_b += b[i+4][j+4]*pix[(x+j)%width, (y+i)%height][2]
            draw.point((x, y), (round(sum_r), round(sum_g), round(sum_b)))
    image2.save(image_name[:-4] + "_gauss" + image_name[-4:])
    del draw

def med(image_name):
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
            for i in range(-2,3):
                for j in range(-2,3):
                    r.append(pix[(x+i)%width, (y+j)%height][0])
                    g.append(pix[(x+i)%width, (y+j)%height][1])
                    b.append(pix[(x+i)%width, (y+j)%height][2])
            medr = sorted(r)[13]
            medg = sorted(g)[13]
            medb = sorted(b)[13]
            draw.point((x, y), (medr, medg, medb))
    image2.save(image_name[:-4] + "_med" + image_name[-4:])
    del draw

def mean(image_name):
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
            for i in range(-2,3):
                for j in range(-2,3):
                    r += pix[(x+i)%width, (y+j)%height][0]
                    g += pix[(x+i)%width, (y+j)%height][1]
                    b += pix[(x+i)%width, (y+j)%height][2]
            draw.point((x, y), (r//25, g//25, b//25))
    image2.save(image_name[:-4] + "_mean" + image_name[-4:])
    del draw