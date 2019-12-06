; MACROS

multiplicacion MACRO op1, op2, res
	mov ax, op1
	mov cx, op2
	imul cx
	mov res, ax
ENDM

division MACRO op1, op2, res
	mov dx, 0
	mov ax, op1
	mov cx, op2
	idiv cx
	cmp dx, 0
	mov res,ax
ENDM

asignar MACRO op1, res
	MOV AX, op1
	MOV res,AX
	XOR AX,AX
ENDM

suma MACRO op1, op2, res
	mov ax, op1
	add ax, op2
	mov res, ax
	xor ax,ax
ENDM

resta MACRO op1, op2, res
	mov ax, op1
	sub ax, op2
	mov res, ax
ENDM

nuevaLinea MACRO
	putc 0Dh
	putc 0Ah
ENDM

incremenarUno MACRO var
	mov ax, var
	inc ax
	mov var,ax
ENDM

printNum MACRO var
    mov ax, var
    call PRINT_NUM
ENDM

printString MACRO var
	mov dx, offset var
	mov ah, 9
	int 21h
ENDM

DEFINE_PRINT_NUM_UNS
DEFINE_PRINT_NUM