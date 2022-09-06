import { createGlobalStyle } from 'styled-components';

/**
 * @issue - GlobalStyle 내부 font url 사용 warning
 */

const GlobalStyle = createGlobalStyle`
    @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        background: #2d2d2d;
        color: #fff;
        font-family: Roboto, sans-serif;
        font-size: 16px;

        a {
            text-decoration: none;
        }
    }
`;

export default GlobalStyle;
