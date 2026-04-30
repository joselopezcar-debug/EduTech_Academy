\# Registro de Mejoras UI/UX con IA - EduTech Academy



\## 1. Auditoría de Pantalla (CoursesScreen)

\- \*\*Problema:\*\* La lista de cursos era visualmente plana y no comunicaba jerarquía. Los botones de filtro eran genéricos y no había manejo de estados vacíos.

\- \*\*Sugerencia de Gemini:\*\* Implementar `ElevatedCard` para profundidad, usar `FilterChips` nativos de Material3, añadir badges ("Popular") y gestionar el caso de "cero resultados".



\## 2. Mejoras Implementadas

1\. \*\*Modernización de Cards:\*\* Se cambió el diseño simple por `ElevatedCard` con bordes de 16.dp y mejor espaciado interno.

2\. \*\*Sistema de Etiquetas (Labels):\*\* Se añadió una lógica para mostrar etiquetas de "POPULAR" en ciertos cursos, mejorando el marketing visual.

3\. \*\*Estado Vacío y Navegación TopBar:\*\* Se agregó un mensaje informativo cuando un filtro no devuelve resultados y se centró el título de la App Bar para un look más moderno.



\### Perfil de la aplicación

\#### Antes

!\[Antes](./docs/Perfil\_Antes.png)

\#### Después

!\[Ahora](./docs/Perfil\_Ahora.png)

\### Cursos

\#### Antes

!\[Antes](./docs/Cursos\_Antes.png)

!\[Antes](./docs/Cursos\_Antes\_2.png)

\#### Después

!\[Ahora](./docs/Cursos\_Ahora.png)

!\[Ahora](./docs/Cursos\_Ahora\_2.png)



\## 3. Prompt usado en Gemini

\*"Analiza mi código de CoursesScreen.kt en Jetpack Compose. Necesito mejorar la jerarquía visual de las tarjetas de cursos, añadir etiquetas como 'Popular' o 'Nuevo', mejorar los botones de filtro y manejar qué pasa cuando una categoría está vacía. Dame el código optimizado."\*



\## 4. Reflexión breve

La implementación de componentes de Material 3 como Chips y ElevatedCards mejora drásticamente la percepción de calidad de la app. El manejo de estados vacíos previene la confusión del usuario.

