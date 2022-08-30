module.exports = {
  env: {
    browser: true,
    es2021: true,
  },
  extends: ['airbnb', 'airbnb/hooks', 'prettier'],
  parserOptions: {
    ecmaVersion: 12,
    sourceType: 'module',
  },
  rules: {
    'linebreak-style': 0,
    'react/prop-types': 'off',
    'no-unused-vars': 'off',
    'function-paren-newline': ['error', 'never'],
    'jsx-a11y/label-has-for': [2, { components: ['Label'], required: { some: ['nesting', 'id'] }, allowChildren: false }],
  },
};
