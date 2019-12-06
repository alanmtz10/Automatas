org 100h

include "emu8086.inc"

imprimir MACRO mensaje
    mov al,mensaje
    cbw
    mov bx,ax
    mov ah,09h
    cbw
    lea dx,bx
    int 21h
ENDM

printString MACRO var
	mov dx, offset var
	mov ah, 9
	int 21h
ENDM

TITLE Operaciones


.MODEL lange
.STACK 64
.DATA

msg1 DB 10,13,"Ingrese el valor de a: ",'$'

.CODE

imprimir 'hola'

.exit