import telebot
from backand_practice import *
import os
import copy
bot = telebot.TeleBot('')
keyboard1 = telebot.types.ReplyKeyboardMarkup()
keyboard2 = telebot.types.ReplyKeyboardMarkup()
keyboard2.row('Нахождение границ(Собель)','Нахождение границ(Превитт)')
keyboard2.row('Размытие по Гауссу','Размытие при помощи мединного значения', 'Размытие при помощи среднего значения')
#Сначала скидывается картинка потом преобразования
global filepath
filepath = 'f'
@bot.message_handler(commands=['start'])
def start_message(message):
    bot.send_message(message.chat.id, 'Привет, ты написал мне /start', reply_markup=keyboard2)

@bot.message_handler(content_types=['photo'])
def handle_docs_photo(message):
    global filepath
    try:
        if filepath != 'f':
            os.remove(filepath)
        file_info = bot.get_file(message.photo[len(message.photo) - 1].file_id)
        downloaded_file = bot.download_file(file_info.file_path)
        src = file_info.file_path;
        filepath = src
        with open(src, 'wb') as new_file:
            new_file.write(downloaded_file)
        bot.reply_to(message, "Фото получил, обрабатываю...")
    except Exception as e:
        bot.reply_to(message, e)

@bot.message_handler(content_types=['document'])
def handle_docs_photo(message):
    try:
        chat_id = message.chat.id
        file_info = bot.get_file(message.document.file_id)
        downloaded_file = bot.download_file(file_info.file_path)
        src = 'E:/' + message.document.file_name;
        bot.reply_to(message,src)
        with open(src, 'wb') as new_file:
            new_file.write(downloaded_file)
        bot.reply_to(message, "Пожалуй, я сохраню это")
    except Exception as e:
        bot.reply_to(message, e)
@bot.message_handler(content_types=['text'])
def get_text_messages(message):
    data = ['Нахождение границ(Собель)','Нахождение границ(Превитт)','Размытие по Гауссу','Размытие при помощи мединного значения', 'Размытие при помощи среднего значения']
    global filepath
    prom = ''
    if message.text in data and filepath != '':

        if message.text == 'Нахождение границ(Собель)':
            sobel(filepath)
            img = open(filepath[:-4] + "_sobel" + filepath[-4:], 'rb')
            bot.send_photo(message.from_user.id, img)
            prom = copy.copy(filepath)
            filepath = filepath[:-4] + "_sobel" + filepath[-4:]
            os.remove(prom)
        elif message.text == 'Нахождение границ(Превитт)':
            previtt(filepath)
            img = open(filepath[:-4] + "_previtt" + filepath[-4:], 'rb')
            bot.send_photo(message.from_user.id,img)
            prom = copy.copy(filepath)
            filepath = filepath[:-4] + "_previtt" + filepath[-4:]
            os.remove(prom)

        elif message.text == 'Размытие по Гауссу':
            gauss(filepath)
            img = open(filepath[:-4] + "_gauss" + filepath[-4:], 'rb')
            bot.send_photo(message.from_user.id,img)
            prom = copy.copy(filepath)
            filepath = filepath[:-4] + "_gauss" + filepath[-4:]
            os.remove(prom)

        elif message.text == 'Размытие при помощи мединного значения':
            filepath
            med(filepath)
            img = open(filepath[:-4] + "_med" + filepath[-4:], 'rb')
            bot.send_photo(message.from_user.id,img)
            prom = copy.copy(filepath)
            filepath = filepath[:-4] + "_med" + filepath[-4:]
            os.remove(prom)

        elif message.text == 'Размытие при помощи среднего значения':
            filepath
            mean(filepath)
            img = open(filepath[:-4] + "_mean" + filepath[-4:], 'rb')
            bot.send_photo(message.from_user.id,img)
            prom = copy.copy(filepath)
            filepath = filepath[:-4] + "_mean" + filepath[-4:]
            os.remove(prom)
    else:
        bot.send_message(message.from_user.id, "пришлите изображение,пожалуйста")
bot.polling()