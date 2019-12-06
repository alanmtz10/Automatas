; MACROS
suma MACRO op1, op2, res
	mov ax, op1
	add ax, op2
	mov res, ax
ENDM

resta MACRO op1, op2, res
	mov ax, op1
	sub ax, op2
	mov res, ax
ENDM

multiplicacion MACRO op1, op2, res
	mov ax, op1
	imul op2
	mov res, ax
ENDM

division MACRO op1, op2, res
	mov dx, 0
	mov ax, op1
	idiv op2
	cmp dx, 0
	jnz approx
	mov res,ax
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