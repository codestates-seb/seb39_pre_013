import { createGlobalStyle } from 'styled-components';

/**
 * @issue - GlobalStyle 내부 font url 사용 warning
 */

const GlobalStyle = createGlobalStyle`
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');
    *,
    *::before,
    *::after {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }

    body {
        font-family: Roboto, sans-serif;
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        color: hsl(210, 4%, 95%);
        min-height: 100vh;
        background-color: #3d3d3d;
    }

    a {
        text-decoration: none;
    }
`;

export default GlobalStyle;
